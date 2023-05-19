package br.com.cod2d.api.domain.dto.shortener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkDTO {

    private Date creationDate;
    private String shortLink;
    private String redirectLink;

}
