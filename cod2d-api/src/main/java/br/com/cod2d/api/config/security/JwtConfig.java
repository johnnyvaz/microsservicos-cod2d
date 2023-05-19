package br.com.cod2d.api.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class JwtConfig {

	@Value("${spring.security.jwt.uri:/**}")
	private String uri;

	@Value("${spring.security.jwt.header:Authorization}")
	private String header;

	@Value("${spring.security.jwt.prefix:Bearer}")
	private String prefix;

	@Value("${spring.security.jwt.secret}")
	private String secret;
}

