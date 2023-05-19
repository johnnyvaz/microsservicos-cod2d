package br.com.cod2d.redirect.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@Configuration
public class OpenAPIConfig {

    private static final String API_KEY = "bearer-key";

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") final String appVersion) {
        return new OpenAPI()
                .components(new Components())
//                        .addSecuritySchemes(API_KEY,
//                                apiKeySecuritySchema()))
                .info(new Info().title("Cod2D Redirect Software")
                        .description("Sistema para gerenciamento do redirecionamento dos links, " +
                                "tanto no padrão GS1 Digital Link quanto os links encurtados")
                        .version(appVersion));
//                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY)));
    }

    public SecurityScheme apiKeySecuritySchema() {
        return
                new SecurityScheme()
                        .name("authorization-token")
                        .description("insira o token sem a palavra 'Bearer'")
                        .scheme("bearer")
                        .in(SecurityScheme.In.HEADER)
                        .bearerFormat("JWT")
                        .type(SecurityScheme.Type.HTTP);
    }
}
