package co.id.qnb.snap.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtBearerTokenAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.OpaqueTokenAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class CustomAuthenticationManagerResolver implements AuthenticationManagerResolver<HttpServletRequest> {

	private AuthenticationManager jwt;
	private AuthenticationManager opaqueToken;

	public CustomAuthenticationManagerResolver(JwtDecoder jwtDecoder, OpaqueTokenIntrospector opaqueTokenIntrospector) {

		JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtDecoder);
		jwtAuthenticationProvider.setJwtAuthenticationConverter(new JwtBearerTokenAuthenticationConverter());
		this.jwt = new ProviderManager(jwtAuthenticationProvider);
		this.opaqueToken = new ProviderManager(new OpaqueTokenAuthenticationProvider(opaqueTokenIntrospector));
	}

	@Override
	public AuthenticationManager resolve(HttpServletRequest request) {
		return useJwt(request) ? jwt : opaqueToken;
	}

	private boolean useJwt(HttpServletRequest request) {
		// Example logic: Use JWT if a certain header is present, otherwise use opaque
		// token
		String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			// You could add further logic to determine if it's JWT (e.g., based on token
			// structure or claims)
			String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
			return isJwtToken(token); // A helper method that checks if the token is JWT
		}

		return false;
	}

	private boolean isJwtToken(String token) {
		// Simple check if the token is a JWT by validating the structure (3 parts
		// separated by dots)
		return token.split("\\.").length == 3;
	}
}
