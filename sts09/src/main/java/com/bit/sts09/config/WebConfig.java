package com.bit.sts09.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
//		<servlet>
//			<servlet-name>appServlet</servlet-name>
//			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//		</servlet>
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
//		<servlet-mapping>
//			<servlet-name>appServlet</servlet-name>
//			<url-pattern>/</url-pattern>
//		</servlet-mapping>
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = null;
		encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		
		return new Filter[] {encodingFilter};
	}

}









