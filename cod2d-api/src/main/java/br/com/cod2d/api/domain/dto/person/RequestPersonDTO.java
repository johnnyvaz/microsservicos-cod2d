package br.com.cod2d.api.domain.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestPersonDTO {

    @NotEmpty
    @Schema(example = "****************", description = "Senha Master para novos cadastros de empresa")
    private String password;

    @NotEmpty
    @Schema(example = "99999999000199", description = "CNPJ da empresa, somente números")
    @JsonProperty("CNPJ")
    private String cnpj;

    @NotEmpty
    @Schema(example = "abcd", description = "Esse nome ficará no link do código GS1, ex: https://cd2.io/abcd/...")
    @JsonProperty("NomeCurto")
    private String nameShort;

    @NotEmpty
    @Schema(example = "Empresa ABCD Cosméticos", description = "Razão Social da Empresa")
    @JsonProperty("NomeEmpresa")
    private String nameOrganization;

    @NotEmpty
    @Schema(example = "ABCD", description = "Será o título e nome da página ")
    @JsonProperty("Fantasia")
    private String fantasia;

    @NotEmpty
    @Schema(example = "https://example.com/logotipo.png", description = "ImagemDTO para montar o cabeçalho do site")
    @JsonProperty("LinkLogotipo")
    private String linkLogotipo;

    @NotEmpty
    @Schema(example = "https://abcd.com", description = "Site da Empresa")
    @JsonProperty("LinkSiteInstitucional")
    private String linkSiteInstitucional;

    @NotEmpty
    @Schema(example = "https://abcd.com/suporte", description = "Site de atendimento ao cliente")
    @JsonProperty("LinkSac")
    private String linkSac;

}
