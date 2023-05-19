package br.com.cod2d.redirect.usecase;

import br.com.cod2d.redirect.domain.dto.product.OrganizationGtinSkuDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Gs1LinkUseCase {

    String getLinkSku(final OrganizationGtinSkuDTO objeto) throws JsonProcessingException;
    String getOrgLinkSku(final OrganizationGtinSkuDTO objeto) throws JsonProcessingException;

}
