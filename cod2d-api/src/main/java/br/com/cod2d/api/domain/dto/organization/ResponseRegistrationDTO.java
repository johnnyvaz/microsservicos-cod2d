package br.com.cod2d.api.domain.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRegistrationDTO {

    private String textoResposta;
    private UUID uuid;
    private String cnpj;
    private String nameShort;
    private String nameOrganization;
    private String fantasia;
    private String linkLogotipo;
    private String linkSiteInstitucional;
    private String linkSac;

}
