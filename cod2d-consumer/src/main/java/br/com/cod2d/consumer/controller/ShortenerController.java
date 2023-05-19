package br.com.cod2d.consumer.controller;

import br.com.cod2d.consumer.config.base.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "Encurtador de Links", description = "Cadastra link encurtador")
@RequestMapping(ShortenerController.PATH)
@RequiredArgsConstructor
public class ShortenerController extends BaseController {

    public static final String PATH = "/shortener";


    @Operation(description = "Busca de links curtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso "),
            @ApiResponse(responseCode = "405", description = "Campos inválidos, favor corrigir"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{name}")
    public ResponseEntity<String> getShortener(
            @PathVariable("name") final String name) throws Exception {
        return buildResponseBody(name, HttpStatus.OK);
    }
}
