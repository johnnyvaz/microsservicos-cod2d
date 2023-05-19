package br.com.cod2d.api.input.controller;

import br.com.cod2d.api.config.base.BaseController;
import br.com.cod2d.api.domain.dto.product.RequestProductGtinDTO;
import br.com.cod2d.api.domain.dto.product.ResponseProductGtinDTO;
import br.com.cod2d.api.usecase.ProductGtinUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Tag(name = "ProductGtinController", description = "API de criação de Código 2D, Criação de Links e paginas")
@RequestMapping(ProductGtinController.PATH)
@RequiredArgsConstructor
public class ProductGtinController extends BaseController {

    public static final String PATH = "/product/gtin";
    private final ProductGtinUseCase useCase;

    @Operation(description = "Insere produto, com base no gtin e criando links gs1 Digital Link ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestProductGtinDTO.class)) }),
            @ApiResponse(responseCode = "405", description = "Campos inválidos, favor corrigir"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/{profileUuid}")
    public ResponseEntity<ResponseProductGtinDTO> sendGtin(
            @PathVariable("profileUuid") final String profileUuid,
            @Valid @RequestBody final RequestProductGtinDTO product) throws Exception {
        log.info("[ProductController] insere um novo produtoDTO ");
        final var sendProduct = useCase.sendGtin(product, profileUuid);
        return buildPostResponseBody(sendProduct);
    }
}
