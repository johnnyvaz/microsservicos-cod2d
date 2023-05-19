package br.com.cod2d.redirect.input.controller;

import br.com.cod2d.redirect.config.base.BaseController;
import br.com.cod2d.redirect.domain.dto.product.OrganizationGtinSkuDTO;
import br.com.cod2d.redirect.usecase.Gs1LinkUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@Tag(name = "Gs1LinkController", description = "API de geração e leitura de links para redirecionar")
@RequestMapping
@RequiredArgsConstructor
public class Gs1LinkController extends BaseController {

    private final Gs1LinkUseCase gs1LinkUseCase;

    @Value("${link.cod2d}")
    private String linkcod2d;

    @Operation(description = "Busca codigo com empresa + uuid + gtin + sku")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Invalid contract"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{organization}/{uuid}/01/{gtin}/22/{sku}")
    public ResponseEntity<Void> getUuidGs1Sku(
            @PathVariable("organization") final String organization,
            @PathVariable("uuid") final String uuid,
            @PathVariable("gtin") final String gtin,
            @PathVariable("sku") final String sku,
            @RequestHeader final HttpHeaders headers) throws JsonProcessingException {
        final OrganizationGtinSkuDTO objeto =
                OrganizationGtinSkuDTO.builder()
                        .organization(organization)
                        .uuid(uuid)
                        .gtin(gtin)
                        .sku(sku)
                        .headers(headers).build();
        log.info("geolocalização : {}", headers.toString());
        final var redirect = gs1LinkUseCase.getOrgLinkSku(objeto);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(redirect)).build();
    }

    @Operation(description = "Busca codigo com empresa + gtin + sku")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Invalid contract"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{shortname}/01/{gtin}/22/{sku}")
    public ResponseEntity<Void> getGs1LinkSku(
            @PathVariable("shortname") final String shortname,
            @PathVariable("gtin") final String gtin,
            @PathVariable("sku") final String sku,
            @RequestHeader final HttpHeaders headers) throws JsonProcessingException {
        final OrganizationGtinSkuDTO objeto = OrganizationGtinSkuDTO.builder()
                .organization(shortname).gtin(gtin).sku(sku).headers(headers).build();
        log.info("geolocalização : {}", headers.toString());
        final var redirect = gs1LinkUseCase.getLinkSku(objeto);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(redirect)).build();
        }

    @Operation(description = "Busca links encurtados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Invalid contract"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{shortname}/01/{gtin}")
    public ResponseEntity<Void> getGs1Link(
            @PathVariable("shortname") final String shortname,
            @PathVariable("gtin") final String gtin,
            @RequestHeader final HttpHeaders headers) throws JsonProcessingException {
        final OrganizationGtinSkuDTO objeto = OrganizationGtinSkuDTO.builder()
                .organization(shortname).gtin(gtin).headers(headers).build();
        log.info("geolocalização : {}", headers.toString());
        final var redirect = gs1LinkUseCase.getLinkSku(objeto);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(redirect)).build();
    }

}
