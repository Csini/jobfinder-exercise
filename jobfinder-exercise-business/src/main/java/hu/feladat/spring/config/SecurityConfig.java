package hu.feladat.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import hu.feladat.spring.auth.AuthenticationFilter;
import hu.feladat.spring.auth.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	AuthenticationService authenticationService;
	
//	@Bean
//	public WebSecurityCustomizer ignoreResources() {
//		return (webSecurity) -> webSecurity.ignoring().antMatchers(
//				"/", "/swagger-ui/**", "**/api-docs/**", "/actuator/**", "/database", "/h2-console/*", "/v3/api-docs/swagger-config", "/v3/api-docs", "/client");
//	}
//	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
    	.headers().frameOptions().sameOrigin()
    	.and()
        .csrf()
          .disable()
          .authorizeRequests()
          .antMatchers(HttpMethod.OPTIONS,"/position/**").permitAll()//allow CORS option calls
          .antMatchers("/", "/swagger-ui/**", "**/api-docs/**", "/actuator/**", "/database", "/h2-console/**", "/v3/api-docs/swagger-config", "/v3/api-docs", "/client").permitAll()
          .anyRequest().authenticated()
//          .antMatchers("/**")
//          .authenticated()
//          .and()
//          .sessionManagement()
//          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
          .addFilterAfter(new AuthenticationFilter(this.authenticationService), BasicAuthenticationFilter.class);

        return http.build();
    }

}