package br.com.cod2d.api.domain.dto.shortener;

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
public class RequestShortLinkDTO {

    @NotEmpty
    @Schema(example = "abc", description = "Descrição do Link, gerado manualmente")
    @JsonProperty("NomeCurto")
    private String shortLink;

    @NotEmpty
    @Schema(example = "https://abcd.com/suporte", description = "Link a ser redirecionado")
    @JsonProperty("Redirect")
    private String redirect;

    @NotEmpty
    @Schema(example = "301625c0-7713-417e-8b5e-f9139adef3e5", description = "id do Usuário logado")
    @JsonProperty("profile_id")
    private String profileId;

}
