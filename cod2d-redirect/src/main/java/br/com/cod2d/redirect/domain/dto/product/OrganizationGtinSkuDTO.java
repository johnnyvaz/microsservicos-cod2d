package br.com.cod2d.redirect.domain.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationGtinSkuDTO {

    private String organization;
    private String uuid;
    private String gtin;
    private String sku;
    private HttpHeaders headers;

}