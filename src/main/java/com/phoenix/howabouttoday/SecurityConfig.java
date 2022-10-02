package com.phoenix.howabouttoday;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	/*
	CSRF(Cross Site Request Forgery)
	웹사이트의 취약점 공격을 방지하기 위해 사용하는 기술
	스프링 시큐어리티가 CSRF 토큰 값을 발행해서
	*/

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       	
    	//인증되지 않은 모든 요청을 허락
    	http
			.authorizeRequests()
				.antMatchers("/").hasRole("MEMBER")
				.antMatchers("/**").permitAll()
			.and()
				.csrf()
//					.ignoringAntMatchers("/**") // 특정 경로만 csrf token 검사 제외
					.disable() // csrf 사용X
				.headers().frameOptions().disable()
			.and()
				.formLogin()
					.loginPage("/home");
   
        return http.build();
    }

}


















