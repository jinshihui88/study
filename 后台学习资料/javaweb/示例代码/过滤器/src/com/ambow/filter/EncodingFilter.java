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
		//����������������ʱ���ø÷�����
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		//��req  �� resp ����servlet ֮ǰ����������һЩ����
		
		//�����ַ����룺
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		 
		System.out.println("�ڵ���servlet֮ǰ�����ַ�����");
		
		//req �� resp ����������󴫵ݣ�
		filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//���������󱻳�ʼ��ʱ���ã�
		System.out.println("filter ���󱻴���");
		
		String encoding = fConfig.getInitParameter("encoding");
		System.out.println(encoding);
		if(encoding != null){
			this.encoding = encoding;
		}
		
		System.out.println("start the filter......");
	}

}
