package br.com.cod2d.api.domain.dto.shortener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListShortLinkDTO {

    private List<ShortLinkDTO> shortLink;

}
