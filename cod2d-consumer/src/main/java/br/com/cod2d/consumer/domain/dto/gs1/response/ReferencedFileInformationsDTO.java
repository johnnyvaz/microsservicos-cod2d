package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReferencedFileInformationsDTO {

    private String languageCode;
    private String contentDescription;
    private String uniformResourceIdentifier;
    private String featuredFile;
    private String referencedFileTypeCode;

}
