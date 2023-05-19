package br.com.cod2d.consumer.config.client.gs1basic;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Gs1BasicConfig {
	
	public static final String NAME = "api-gs1";
    public static final String GET_GTIN = "/gs1/v0/products/0{gtin}";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }
}