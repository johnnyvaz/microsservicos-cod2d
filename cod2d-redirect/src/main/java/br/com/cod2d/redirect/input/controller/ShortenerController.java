package br.com.cod2d.redirect.input.controller;

import br.com.cod2d.redirect.config.base.BaseController;
import br.com.cod2d.redirect.usecase.RedirectUseCase;
import br.com.cod2d.redirect.usecase.ShortenerUseCase;
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
@Tag(name = "ShortenerController", description = "API de geração e leitura de links para redirecionar")
@RequestMapping
@RequiredArgsConstructor
public class ShortenerController extends BaseController {

    private final ShortenerUseCase shortenerUseCase;
    private final RedirectUseCase redirectUseCase;

    @Value("${link.cod2d}")
    private String linkcod2d;

    @Operation(description = "Busca links encurtados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Invalid contract"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{shortlink}")
    public ResponseEntity<Void> getLink(
            @PathVariable("shortlink") final String shortlink,
            @RequestHeader final HttpHeaders headers) throws JsonProcessingException {
        log.info("geolocalização : {}", headers.toString());
        final var redirect = shortenerUseCase.getLink(shortlink, headers);
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .location(URI.create(redirect)).build();
    }

    @Operation(description = "redirect cod2d.com.br")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Invalid contract"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/")
    public ResponseEntity<Void> getLinkPath(@RequestHeader final HttpHeaders headers)
            throws JsonProcessingException {
        log.info("geolocalização : {}", headers.toString());
        final var redirect = redirectUseCase.postLink(headers);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(redirect)).build();
    }
}
