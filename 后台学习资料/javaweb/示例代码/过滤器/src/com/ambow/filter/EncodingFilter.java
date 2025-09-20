package com.ambow.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding = null;

	public void destroy() {
		//当过滤器对象被销毁时调用该方法：
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		//在req  和 resp 调到servlet 之前可以在这做一些处理：
		
		//设置字符编码：
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		 
		System.out.println("在调到servlet之前设置字符编码");
		
		//req 和 resp 对象继续往后传递：
		filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//过滤器对象被初始化时调用：
		System.out.println("filter 对象被创建");
		
		String encoding = fConfig.getInitParameter("encoding");
		System.out.println(encoding);
		if(encoding != null){
			this.encoding = encoding;
		}
		
		System.out.println("start the filter......");
	}

}
