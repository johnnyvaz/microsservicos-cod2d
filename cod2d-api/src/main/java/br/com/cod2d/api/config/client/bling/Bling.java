package br.com.cod2d.api.config.client.bling;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class Bling {
	
	public static final String NAME = "api-bling";
    public static final String GET_PRODUCTS = "/Api/v2/produtos/json/";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }
	
}
