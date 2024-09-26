package co.id.qnb.snap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver;

	private final String[] freeResourceUrls = { "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**",
			"/swagger-resources/**", "/api-docs/**" };

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// @formatter:off
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(freeResourceUrls)
                .permitAll()
                .anyRequest().authenticated())
			.oauth2ResourceServer(oauth2 -> oauth2
				.authenticationManagerResolver(this.authenticationManagerResolver)
			).build();
		// @formatter:on
	}


}
