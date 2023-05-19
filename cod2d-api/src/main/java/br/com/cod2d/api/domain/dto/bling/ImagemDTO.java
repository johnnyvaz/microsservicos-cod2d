package br.com.cod2d.api.domain.dto.bling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {
    public String link;
    public String validade;
    public String tipoArmazenamento;
}
