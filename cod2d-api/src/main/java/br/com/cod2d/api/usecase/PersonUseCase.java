package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.organization.RequestOrganizationDTO;
import br.com.cod2d.api.domain.dto.organization.ResponseRegistrationDTO;

public interface PersonUseCase {

    ResponseRegistrationDTO run(final RequestOrganizationDTO request) throws Exception;
}
