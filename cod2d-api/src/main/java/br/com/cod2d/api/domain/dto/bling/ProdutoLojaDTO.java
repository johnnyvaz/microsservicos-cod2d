package br.com.cod2d.api.domain.dto.bling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoLojaDTO {
    public PrecoDTO precoDTO;
    public ArrayList<CategoriumDTO> categoria;
}
