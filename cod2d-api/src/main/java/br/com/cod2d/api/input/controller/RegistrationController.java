//package br.com.cod2d.api.input.controller;
//
//import br.com.cod2d.api.config.base.BaseController;
//import br.com.cod2d.api.domain.dto.organization.RequestOrganizationDTO;
//import br.com.cod2d.api.domain.dto.organization.ResponseRegistrationDTO;
//import br.com.cod2d.api.domain.dto.softup.RequestIntegracaoProdutosDTO;
//import br.com.cod2d.api.usecase.RegistrationUseCase;
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
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@Slf4j
//@RestController
//@Tag(name = "Cadastros Iniciais da Empresa e Usuário", description = "Assim que você receber a chave de acesso " +
//        " o primeiro passo é enviar os dados para construção da estrutura da empresa vinculando no usuário")
//@RequestMapping(RegistrationController.PATH)
//@RequiredArgsConstructor
//public class RegistrationController extends BaseController {
//
//    public static final String PATH = "/registration";
//    private final RegistrationUseCase organizationUseCase;
//
//        // @PreAuthorize("hasRole(admin)")
//        @Operation(description = "Envia dados da empresa e usuário para inicio da Integração de produtoDTOS")
////security = { @SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) },
//// tags = { "softup" })
//        @ApiResponses(value = {
//                @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso ",
//                        content = { @Content(mediaType = "application/json",
//                                schema = @Schema(implementation = RequestIntegracaoProdutosDTO.class)) }),
//                @ApiResponse(responseCode = "405", description = "Campos inválidos, favor corrigir"),
//                @ApiResponse(responseCode = "500", description = "Internal server error")
//        })
//        @PostMapping(name = "/organization", consumes = {"application/json"})
//        public ResponseEntity<ResponseRegistrationDTO> register(
////                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "parametro teste aqui")
//                @Valid @RequestBody final RequestOrganizationDTO request) throws Exception {
//        final var sendOrganization = organizationUseCase.run(request);
//        return buildResponseBody(sendOrganization, HttpStatus.CREATED);
//    }
//
////    @Operation(description = "Cadastro de Pessoa")
//////security = { @SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) },
////// tags = { "softup" })
////    @ApiResponses(value = {
////            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso ",
////                    content = { @Content(mediaType = "application/json",
////                            schema = @Schema(implementation = RequestIntegracaoProdutosDTO.class)) }),
////            @ApiResponse(responseCode = "405", description = "Campos inválidos, favor corrigir"),
////            @ApiResponse(responseCode = "500", description = "Internal server error")
////    })
////    @PostMapping( name = "/organization", consumes = { "application/json" })
////    public ResponseEntity<ResponseRegistrationDTO> registerPerson(
//////                @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "parametro teste aqui")
////            @Valid @RequestBody final RequestOrganizationDTO request) throws Exception {
////        final var sendOrganization = organizationUseCase.run(request);
////        return buildResponseBody(sendOrganization, HttpStatus.CREATED);
////    }
//
//}
