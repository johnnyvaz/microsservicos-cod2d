package br.com.cod2d.api.domain.dto.maker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrganizationMakerDTO {

    private UUID organizationUuid;

}
