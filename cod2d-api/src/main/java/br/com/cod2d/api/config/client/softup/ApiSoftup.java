package br.com.cod2d.api.config.client.softup;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ApiSoftup {
	
	public static final String NAME = "api-softup";
    public static final String GET_PRODUCTS = "/api/rest/api_sgo/wsconsultaprodutos";

    public static final String CHANGE_PRODUCTS = "/api/rest/api_sgo/wsatualizaprodutos";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }
	
}
