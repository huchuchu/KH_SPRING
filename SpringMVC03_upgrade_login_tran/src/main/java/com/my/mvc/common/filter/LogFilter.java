package com.my.mvc.common.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
													//loggerFilter.class화 관련된 애들을 log찍어주겠다
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	
	//servletFilter 클래스 초기화를 수행하는 메소드
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
	// servletFilter의 주된 기능을 수행할 메소드이다. 
	// FilterChain: request 와 response를 묶어줌??
	// 필터를 거쳐서 request 와 response 가 실행되기때문에 묶어주는게 필요하다
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		String RemoteAddr = StringUtils.defaultString(req.getRemoteAddr()); //ip주소(0:0:0:0:0:0:0) IPV6=> 클라이언트의 IP
		String uri = StringUtils.defaultString(req.getRequestURI()); 			//mvc/list.do
		String url = StringUtils.defaultString(req.getRequestURI().toString()); //전체
		String queryString = StringUtils.defaultString(req.getQueryString());   //?id=admin
		String referer = StringUtils.defaultString(req.getHeader("referer")); //이전단계
		String agent = StringUtils.defaultString(req.getHeader("User-Agent")); //브라우저 버전 
		
		StringBuffer result = new StringBuffer();
		result.append(":")
			  .append("RemoteAddr->"+RemoteAddr)
			  .append("uri->"+uri)
			  .append("(")
			  .append("url->"+url)
			  .append("?"+queryString)
			  .append(")")
			  .append("referer->"+referer)
			  .append(":")
			  .append("agent->"+agent);
		
		logger.info("LOG Filter" + result.toString());
		
		chain.doFilter(req, response);
	//	chain.doFilter(req, response);
		
	}
	
	
	//servletFilter 클래스 제거시 수행되어질 메소드이다 
	@Override
	public void destroy() {
		
	}

}
