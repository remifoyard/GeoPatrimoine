package com.equipe4.GeoPatrimoine1.Filter;

import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* This filter allow CORS request for everyone
*/
@Component
public class CORSFilter implements Filter {

/**
* For each HTTP Response add CORS authorization
*
* @param req the request
* @param res the response
* @param chain the filterChain
*/ 
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
throws IOException, ServletException {
	
HttpServletRequest requestToUse = (HttpServletRequest) request;
HttpServletResponse responseToUse = (HttpServletResponse) response;
System.out.println(requestToUse.getHeader("Origin"));
responseToUse.setHeader("Access-Control-Allow-Origin", requestToUse.getHeader("Origin"));

responseToUse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
responseToUse.setHeader("Access-Control-Allow-Credentials", "true");


chain.doFilter(request, response);
}

/**
* The initialization of the Filter (do nothing here)
*/
public void init(FilterConfig filterConfig) {
}

/**
* The destruction of the filter, (do nothing here)
*/
public void destroy() {
}

}