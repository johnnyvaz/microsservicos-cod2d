//package br.com.cod2d.api.input.controller;
//
//import br.com.cod2d.api.config.base.BaseController;
//import br.com.cod2d.api.domain.dto.softup.RequestIntegracaoProdutosDTO;
//import br.com.cod2d.api.usecase.SoftupProductUseCase;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.UUID;
//
//@Slf4j
//@RestController
//@Tag(name = "Integração SoftUp", description = "Esta API faz a comunicação com o Sistema Gestão Online e Cria o" +
//        " link no padrão GS1 Digital LinkGs1 com o redirecionamento de uma pagina para ficha técnica do produtoDTO")
//@RequestMapping(SoftupProductController.PATH)
//@RequiredArgsConstructor
//public class SoftupProductController extends BaseController {
//
//    public static final String PATH = "/softup/product";
//    private final SoftupProductUseCase softupProductUseCase;
//
//        @Operation(description = "Integração de produtoDTOS com o sistema Gestão Online - (SoftUp) \n " +
//            "os campos de filtro não são obrigatórios, nesse caso serão integrados todos os produtoDTOS")
////security = { @SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) },
//// tags = { "softup" })
//        @ApiResponses(value = {
//                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso, " +
//                        "pode demorar até 2 horas para criação do site",
//                        content = { @Content(mediaType = "application/json",
//                                schema = @Schema(implementation = RequestIntegracaoProdutosDTO.class)) }),
//                @ApiResponse(responseCode = "405", description = "Campos inválidos, favor corrigir"),
//                @ApiResponse(responseCode = "500", description = "Internal server error")
//        })
//        @PostMapping("/{organizationUuid}")
//        public ResponseEntity softupIntegration(
////                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "parametro teste aqui")
//                @PathVariable("organizationUuid") final String organizationUuid,
//                @Valid @RequestBody final RequestIntegracaoProdutosDTO request) throws Exception {
//            final var uuid = UUID.fromString(organizationUuid);
//            final String sendProduct = softupProductUseCase.run(request, uuid.toString());
//            return buildResponseBody(sendProduct, HttpStatus.CREATED);
//    }
//
//}
