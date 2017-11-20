package com.mywork.springmvc.configuration;

/**
 * @author ManiKanta Kandagatla
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mywork.springmvc")
public class HelloWorldConfiguration
{

}