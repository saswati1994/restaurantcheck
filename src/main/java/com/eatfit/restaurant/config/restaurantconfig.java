package com.eatfit.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
@EnableWebSecurity
public class restaurantconfig extends WebSecurityConfigurerAdapter
{
	protected void configure(HttpSecurity security) throws Exception
    {       
       
        security.httpBasic().disable();
        security.csrf().disable();
        security
        
          .authorizeRequests()
         .antMatchers(HttpMethod.POST,"/**").permitAll()
         .antMatchers("/resources/**", "/WEB-INF/Item/*").permitAll()
      
         ;
    }
	
	@Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("/WEB-INF/Item/");
        templateResolver.setSuffix(".jsp");
       // templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
}
