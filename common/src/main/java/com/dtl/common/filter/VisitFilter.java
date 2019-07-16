package com.dtl.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域
 * @author LBZ
 */
public class VisitFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			HttpServletResponse resp = (HttpServletResponse) servletResponse;
			HttpServletRequest req = (HttpServletRequest) servletRequest;
			String origin = req.getHeader("Origin");
			resp.setHeader("Access-Control-Allow-Origin", origin);
			resp.setHeader("Access-Control-Allow-Credentials","true");
			//跨域 Header
			resp.setHeader("Access-Control-Allow-Methods", "*");
			resp.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
			// 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
			// 配置options的请求返回
			if ("OPTIONS".equals(req.getMethod())) {
				resp.setStatus(200);
				resp.getWriter().write("OPTIONS returns OK");
				return;
			}
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {

	}
}
