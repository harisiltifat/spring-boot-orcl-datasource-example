package com.github.tiagomac.authentication;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.SimpleAttributes2GrantedAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;
import org.springframework.security.web.authentication.preauth.j2ee.J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.j2ee.WebXmlMappableAttributesRetriever;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//https://www.tabnine.com/code/java/methods/org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter/setAuthenticationManager
	//Link: http://javaworkbench.blogspot.com/2012/10/container-based-authentication-with.html
	//Link: https://stackoverflow.com/questions/28172056/spring-security-using-jboss-security-domain
  //https://docs.spring.io/spring-security/site/docs/3.0.x/reference/preauth.html
  //https://gist.github.com/yashpatil

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		J2eePreAuthenticatedProcessingFilter filter = new J2eePreAuthenticatedProcessingFilter();
//		
//		J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource j2eeDetailSource=new J2eeBasedPreAuthenticatedWebAuthenticationDetailsSource();
//		
//		
//		WebXmlMappableAttributesRetriever webxmlRetriever=new WebXmlMappableAttributesRetriever();
//		SimpleAttributes2GrantedAuthoritiesMapper sime2Granted=new SimpleAttributes2GrantedAuthoritiesMapper();
//		j2eeDetailSource.setMappableRolesRetriever(webxmlRetriever);
//		j2eeDetailSource.setUserRoles2GrantedAuthoritiesMapper(sime2Granted);
//		
//		filter.setAuthenticationManager(this.auth.getObject());
//		filter.setAuthenticationDetailsSource(j2eeDetailSource);

//	     http
//         .authorizeRequests()
//         .antMatchers("/**").hasRole("migpool")
//         .and()
//         .httpBasic();

//		http
//		.addFilterBefore(filter, J2eePreAuthenticatedProcessingFilter.class)
//		.authorizeRequests()
//		.antMatchers("/**")
//		.hasRole("migpool")
//		.and()
//		.authenticationProvider(new PreAuthenticatedAuthenticationProvider())
//		.formLogin();
		
//		http
//		.addFilter(filter)
//		.authorizeRequests().anyRequest()
//		.authenticated()
//        .anyRequest().hasRole("migpool")
//        .and()
//        //.authenticationProvider(new PreAuthenticatedAuthenticationProvider())
//        .formLogin();
		
//		http
//        .authorizeRequests()
//        .antMatchers("/**").hasRole("migpool")
//        .and()
//        .jee().mappableRoles("migpool")
//       ;
        
		//J2eePreAuthenticatedProcessingFilter filter = new J2eePreAuthenticatedProcessingFilter();			
		//filter.setAuthenticationManager(authenticationManager());

		
        http
        .jee()
        .mappableAuthorities("migpool","vip")
        ;
		
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(new PreAuthenticatedAuthenticationProvider());
//		//this.auth=auth;
//		
//	}


//	@Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
//		J2eePreAuthenticatedProcessingFilter filter = new J2eePreAuthenticatedProcessingFilter();
//		filter.setAuthenticationManager(authenticationManager());
//        http
//        .addFilterAfter(filter, BasicAuthenticationFilter.class)
        //.authorizeRequests()
        //.antMatchers("/**")
        //.hasRole("migpool")
        //.and()
        //.authenticated()
        //.and()
        //.authenticationProvider(getAuthenticationProvider())
//        .jee().mappableRoles("migpool")
//        ;
//        
//        return http.build();
//    }
	
//	@Bean
//    public AuthenticationProvider getAuthenticationProvider() {
//		PreAuthenticatedGrantedAuthoritiesUserDetailsService userDetailService=new PreAuthenticatedGrantedAuthoritiesUserDetailsService();
//		PreAuthenticatedAuthenticationProvider authProvider=new PreAuthenticatedAuthenticationProvider();
//		
//		authProvider.setPreAuthenticatedUserDetailsService(userDetailService);
//        return authProvider;
//    }
	

   

}
