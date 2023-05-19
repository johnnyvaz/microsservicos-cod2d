package br.com.cod2d.api.domain.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductGtinDTO {

   private String gtin;
   private String uuid;
   private String gs1DigitalLink;
   private Date creationDate;
   private String linkReduzido;
   private String urlRedirect;
   private Boolean enabled;



}