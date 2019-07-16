package com.dtl.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;

/**
 * 跨域
 * @author LBZ
 */
@Configuration
public class WebMvcConfigurerAdapter{
	
	    private CorsConfiguration buildConfig() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.addAllowedOrigin("*");
	        corsConfiguration.addAllowedHeader("*");
	        corsConfiguration.addAllowedMethod("*");
	        return corsConfiguration;
	    }

	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", buildConfig());
	        return new CorsFilter(source);
	    }
	    
		@Bean
		public FilterRegistrationBean someFilterRegistration() {
			FilterRegistrationBean registration = new FilterRegistrationBean();
			registration.setFilter(visitFilter());
			registration.addUrlPatterns("/*");
			registration.addInitParameter("paramName", "paramValue");
			registration.setName("visitFilter");
			return registration;
		}

		@Bean
		public Filter visitFilter() {
			return new VisitFilter();
		}
}
