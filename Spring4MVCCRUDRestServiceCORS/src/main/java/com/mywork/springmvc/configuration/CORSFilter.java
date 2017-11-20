package com.mywork.springmvc.configuration;

/**
 * @author ManiKanta Kandagatla
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class CORSFilter implements Filter
{

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        CorsRegistry registry = new CorsRegistry();
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:3000", "http://localhost:3000",
                        "http://192.168.1.145:3000")
                .allowedMethods("*").allowedHeaders("*").exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig)
    {
    }

    public void destroy()
    {
    }

}

/*@Configuration
@EnableWebMvc
public class CORSFilter extends WebMvcConfigurerAdapter {
 public class CORSFilter extends WebMvcConfigurationSupport {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http: 127.0.0.1:3000","http: localhost:3000","http: 192.168.1.145:3000")
        .allowedMethods("*")
        .allowedHeaders("*")
         .exposedHeaders("header1", "header2")
        .allowCredentials(false).maxAge(3600);
    }
}*/