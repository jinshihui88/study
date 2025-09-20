package com.aia.mypage.service.impl;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aia.mypage.entity.Permission;
import com.aia.mypage.service.ActiveLogService;
import com.aia.mypage.util.BaseUtil;
import com.aia.mypage.util.constant.ConfigConstant;
import com.aia.mypage.util.httpclient.HttpClientUtil;

public class ActiveLogServiceImpl implements ActiveLogService {

    @Autowired
    @Qualifier(value = "permissionServiceImpl")
    private PermissionServiceImpl permissionServiceImpl;

    //Add a log to the login function,insert into db_cus..T_ACTIVITY_LOG table
    public Map<String, Object> addLog(HttpServletRequest request, String channel, String partyId) {
        //request URL
        String url = request.getRequestURI().toString();
        //request method
        String method = request.getMethod();
        //ip 
        String ip = request.getRemoteAddr();
        //The interface address of the call
        String forwardUrl = ConfigConstant.configMap.get(ConfigConstant.TRANSACTION_LOG_FORWRAD_URL);

        String key = getTransactionKey(method, url);
        if (BaseUtil.permissionMap == null) {
            permissionServiceImpl.initPermissionMap();
        }
        Permission permission = BaseUtil.permissionMap.get(key);
        //Get the interface ID
        String actionType = permission.getPermissionId();
        //Get the interface description
        String actionDesc = permission.getPermissionDesc();
        String permissionpattern = permission.getPermissionPattern();
        
        //Create a collection of parameters
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("partyId", partyId);
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> activityLog = new HashMap<String, Object>();
        activityLog.put("actionType", actionType);
        activityLog.put("actionDesc", actionDesc);
        activityLog.put("channel", channel);
        activityLog.put("polNum", "");
        activityLog.put("ip", ip);
        activityLog.put("requestUri", permissionpattern);
        activityLog.put("requestMethod", method);
        activityLog.put("responseCode", "200");
        activityLog.put("serviceRequestCode", "");
        data.put("activityLog", activityLog);
        map.put("data", data);
        HttpClientUtil httpClient = new HttpClientUtil(forwardUrl, map);
        Map<String, Object> jsonMap = httpClient.httpClientJSONNew(BaseUtil.REQUEST_METHOD_POST);
        return jsonMap;
    }

    private String getTransactionKey(String method, String requestUri) {
        return method + "-" +requestUri.substring(requestUri.indexOf("/", 2));
    }
}
