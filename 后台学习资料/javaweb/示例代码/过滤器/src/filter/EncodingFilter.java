package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("doFilter方法被调用。。。。。。");
		req.setCharacterEncoding("GB2312");
		resp.setContentType("text/html; charset=GB2312");
		
		fc.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init方法被调用。。。。。。。");
	}
	
}
