package com.hong.restclient.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
		http.oauth2Client(withDefaults());
		return http.build();
	}

	@Bean
	public RestTemplate oauth2RestTemplate(OAuth2HttpRequestInterceptor oAuth2HttpRequestInterceptor) {
		RestTemplate restTemplate = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}
		interceptors.add(oAuth2HttpRequestInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	// hong code
	@Bean
  	public ClientRegistrationRepository clientRegistrationRepository() {
    	ClientRegistration c1 = ClientRegistration
        	.withRegistrationId("demo-client")
        	.clientId("client")
        	.clientSecret("secret")
        	.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
        	.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        	.tokenUri("http://localhost:7070/oauth2/token")
        	.scope(OidcScopes.OPENID)
        	.build();

    	var repository = new InMemoryClientRegistrationRepository(c1);

    	return repository;
  	}
}
