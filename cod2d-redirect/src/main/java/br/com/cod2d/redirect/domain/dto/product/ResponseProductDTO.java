package br.com.cod2d.redirect.domain.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {

    private String uuid;
    private String sku;
    private String gtinEan;
    private String linkGS1;
    private String codigosGerados;
    private String linkDownloadQrcode;
    private String linkRedirecionamento;


}