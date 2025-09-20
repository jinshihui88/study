package com.aia.mypage.util.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.aia.mypage.entity.ResponseVO;
import com.aia.mypage.util.BaseUtil;
import com.aia.mypage.util.aes.AESUtil;
import com.aia.mypage.util.constant.ConfigConstant;
import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {

    /*
     * Available content Types
     */
    public static final List<ContentType> CONTENT_TYPES = Arrays.asList(ContentType.TEXT_PLAIN, ContentType.TEXT_HTML,
            ContentType.TEXT_XML, ContentType.APPLICATION_XML, ContentType.APPLICATION_SVG_XML,
            ContentType.APPLICATION_XHTML_XML, ContentType.APPLICATION_ATOM_XML,
            ContentType.APPLICATION_FORM_URLENCODED, ContentType.APPLICATION_JSON,
            ContentType.APPLICATION_FORM_URLENCODED);

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

    // Convert mill seconds to second unit
    protected static final int MS_TO_S_UNIT = 1000;

    protected static final HttpsTrustManager httpsTrustManager = new HttpsTrustManager();

    // https prefix
    protected static final String HTTPS = "https";

    protected String url;

    protected int maxConnectionSeconds = 8;

    protected String contentType = "application/x-www-form-urlencoded;charset=UTF-8";

    protected Map<String, String> requestHeaders;

    protected Map<String, Object> requestParams = new HashMap<String, Object>();

    protected boolean isProxy = false;

    public HttpClientUtil(String url, Map<String, Object> requestParams) {
        this.url = url;
        this.requestParams = requestParams;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    // judge if proxy is needeed
    public void setProxy(boolean isProxy) {
        this.isProxy = isProxy;
    }

    public CloseableHttpResponse execute(String requestMethod) throws ClientProtocolException, IOException {
        LOG.info(url);
        RequestBuilder builder = createRequestBuilder(requestMethod);
        builder.setUri(url);
        addRequestHeaders(builder);
        addRequestParams(builder);
        HttpUriRequest request = builder.build();
        setContentType(request);
        CloseableHttpResponse response = sendRequest(request);
        return response;
    }

    private CloseableHttpResponse sendRequest(HttpUriRequest request) throws IOException {

        CloseableHttpClient client = retrieveHttpClient();

        CloseableHttpResponse response = null;
        try {

            response = client.execute(request);

        }
        catch (ClientProtocolException e) {
            LOG.error(" Error Log:" + e);
        }
        catch (IOException e) {
            LOG.error(" Error Log:" + e);
        }
        return response;

    }

    public ResponseVO executeNew(String requestMethod) throws ClientProtocolException, IOException {
        LOG.info(url);
        RequestBuilder builder = createRequestBuilder(requestMethod);
        builder.setUri(url);
        addRequestHeaders(builder);
        addRequestParams(builder);
        HttpUriRequest request = builder.build();
        setContentType(request);
        return sendNewRequest(request);
    }

    private ResponseVO sendNewRequest(HttpUriRequest request) throws IOException {

        CloseableHttpClient client = retrieveHttpClient();

        CloseableHttpResponse response = null;
        try {
            response = client.execute(request);
            if (response == null) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, BaseUtil.UTF8_ENCODING);
            ResponseVO vo = new ResponseVO();
            vo.setResult(result);
            vo.setStatusCode(response.getStatusLine().getStatusCode());
            return vo;
        }
        catch (ClientProtocolException e) {
            LOG.error("ClientProtocolException log: " + e);
        }
        catch (IOException e) {
            LOG.error("IOException log: " + e);
        }
        finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }

        return null;
    }

    // setup httpClient
    private CloseableHttpClient retrieveHttpClient() {

        String seconds = ConfigConstant.configMap.get(ConfigConstant.HTTP_CLIENT_MAX_CONNECTION_SECONDS);
        if (!StringUtils.isBlank(seconds)) {
            maxConnectionSeconds = Integer.parseInt(seconds);
        }

        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(maxConnectionSeconds * MS_TO_S_UNIT)
                .setConnectTimeout(maxConnectionSeconds * MS_TO_S_UNIT)
                .setSocketTimeout(maxConnectionSeconds * MS_TO_S_UNIT).build();
        HttpClientBuilder builder = HttpClients.custom().setDefaultRequestConfig(requestConfig);
        if (isHttps()) {
            // Support SSL
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(createSSLContext());
            builder.setSSLSocketFactory(sslConnectionSocketFactory);
        }
        if (isProxy) {
            HttpHost proxy = new HttpHost(ConfigConstant.configMap.get(ConfigConstant.PROXY_HOSTNAME),
                    Integer.parseInt(ConfigConstant.configMap.get(ConfigConstant.PROXY_PORT)));
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);

            String serverName = ConfigConstant.configMap.get(ConfigConstant.SERVER_CONFIG_NAME);

            if (StringUtils.equals("uat", serverName)) {
                builder.setRoutePlanner(routePlanner);
            } else if (StringUtils.equals("sit", serverName)) {
                CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                Credentials cred = new UsernamePasswordCredentials(
                        ConfigConstant.configMap.get(ConfigConstant.PROXY_USERNAME), decode());
                credentialsProvider.setCredentials(AuthScope.ANY, cred);
                builder.setRoutePlanner(routePlanner).setDefaultCredentialsProvider(credentialsProvider);
            }
        }
        return builder.build();
    }

    public String decode() {
        String encode = ConfigConstant.configMap.get(ConfigConstant.PROXY_PASSWORD);
        String password = AESUtil.decode(encode);
        return password;
    }

    private SSLContext createSSLContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new HttpsTrustManager[] { httpsTrustManager }, null);
            return sslContext;
        }
        catch (Exception e) {
            throw new IllegalStateException("Create SSLContext error", e);
        }
    }

    /**
     * Default X509TrustManager implement
     */
    private static class HttpsTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            // ignore
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            // ignore
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private boolean isHttps() {

        if (url.toLowerCase().startsWith("https")) {
            return true;
        }
        return false;
    }

    private void setContentType(HttpUriRequest request) {

        if (this.contentType != null) {
            request.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            LOG.debug("Set HttpUriRequest[{}] contentType: {}", request, contentType);
        }
    }

    private void addRequestParams(RequestBuilder builder) {

        if (this.requestParams == null) {
            return;
        }
        try {
            for (String key : requestParams.keySet()) {
                builder.addParameter(key, (String) requestParams.get(key));
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            return;
        }

    }

    private void addRequestHeaders(RequestBuilder builder) {

        if (this.requestHeaders == null) {
            return;
        }
        for (String key : requestHeaders.keySet()) {
            builder.addHeader(key, requestHeaders.get(key));
        }
    }

    protected RequestBuilder createRequestBuilder(String requestMethod) throws UnsupportedEncodingException {

        RequestBuilder builder = null;
        StringEntity se = null;
        if (requestParams != null) {
            Object object = JSONObject.toJSON(requestParams);
            se = new StringEntity(object.toString());
            se.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }

        if (BaseUtil.REQUEST_METHOD_GET.equalsIgnoreCase(requestMethod)) {
            builder = RequestBuilder.get();
            addRequestParams(builder);
        } else if (BaseUtil.REQUEST_METHOD_POST.equalsIgnoreCase(requestMethod)) {
            builder = RequestBuilder.post();
            builder.setEntity(se);
            // builder.setHeader(HTTP.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
        } else if (BaseUtil.REQUEST_METHOD_PUT.equalsIgnoreCase(requestMethod)) {
            builder = RequestBuilder.put();
            builder.setEntity(se);
        } else if (BaseUtil.REQUEST_METHOD_DELETE.equalsIgnoreCase(requestMethod)) {
            builder = RequestBuilder.delete();
        }
        return builder;
    }

    public int getReponseCode(CloseableHttpResponse response) {

        if (response != null) {
            return response.getStatusLine().getStatusCode();
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> httpClientJSON(String requestMethod) {

        Map<String, Object> jsonObject = new HashMap<String, Object>();
        try {

            CloseableHttpResponse response = execute(requestMethod);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            jsonObject = (Map<String, Object>) JSONObject.parse(result);
            if (response != null) {
                response.close();
            }
        }
        catch (Exception e) {
            LOG.error("error :" + e);
        }

        return jsonObject;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> httpClientJSONNew(String requestMethod) {

        Map<String, Object> jsonObject = new HashMap<String, Object>();
        try {
            ResponseVO response = executeNew(requestMethod);
            String result = response.getResult();
            jsonObject = (Map<String, Object>) JSONObject.parse(result);
        }
        catch (Exception e) {
            LOG.error("error :" + e);
        }

        return jsonObject;
    }

}
