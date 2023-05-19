//package br.com.cod2d.api.integration.input.controller;
//
//
//import br.com.cod2d.api.config.slack.SlackServiceNotifier;
//import br.com.cod2d.api.domain.dto.product.RequestProductDTO;
//import br.com.cod2d.api.input.controller.ShortenerController;
//import br.com.cod2d.api.input.controller.advicer.ApiControllerAdvice;
//import br.com.cod2d.api.integration.config.IntegrationTestConfig;
//import br.com.cod2d.api.usecase.utils.ConvertUtils;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//class ProductControllerTest extends IntegrationTestConfig {
//
//    public static final String API_PRODUCT = ShortenerController.PATH;
//
//    private final static String PATH_JSON = "src/test/resources/object-json/";
//
//    @MockBean
//    public SlackServiceNotifier slackServiceNotifier;
//
//    @Autowired
//    public ShortenerController controller;
//
//    public MockMvc mockMvc;
//
//    @BeforeAll
//    void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller)
//                .setControllerAdvice(new ApiControllerAdvice())
//                .build();
//    }
//
//    private String toJson(final Object o) {
//        return new Gson().toJson(o);
//    }
//
//    @Test
//    void shouldReturnResponseEmptyWithSuccess() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get(API_PRODUCT)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("utf-8"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    @Sql("classpath:sql/product-basic.sql")
//    void shouldReturnResponseDTOWithSuccess() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get(API_PRODUCT)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("utf-8"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.errors").doesNotExist())
//                .andExpect(jsonPath("$.records").exists())
//                .andExpect(jsonPath("$.records[*]").isNotEmpty())
//                .andExpect(jsonPath("$.meta.recordCount").isNumber())
//                .andExpect(jsonPath("$.records").isArray())
//                .andExpect(jsonPath("$.records[0].id").value(1))
//                .andExpect(jsonPath("$.records[0].idOrganization").value(1))
//                .andExpect(jsonPath("$.records[0].sku").value("9879797978"))
//                .andExpect(jsonPath("$.records[0].description").value("ProdutoDTO teste"))
//                .andExpect(jsonPath("$.records[0].gtinEan").value("987987987"))
//                .andExpect(jsonPath("$.records[0].processed").value("N"))
//                .andExpect(jsonPath("$.records[0].enabled").value(true));
//    }
//
//    @Test
//    void shouldReturnResponse200WithSendProduct() throws Exception {
//        final RequestProductDTO product = ConvertUtils
//                .readFileJsonToObject(PATH_JSON + "request-new-product-1.json", RequestProductDTO.class);
//        this.mockMvc.perform(MockMvcRequestBuilders.post(API_PRODUCT)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(toJson(product))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("utf-8"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.errors").doesNotExist())
//                .andExpect(jsonPath("$.records").exists())
//                .andExpect(jsonPath("$.records[*]").isNotEmpty())
//                .andExpect(jsonPath("$.meta.recordCount").isNumber())
//                .andExpect(jsonPath("$.records").isArray())
//                .andExpect(jsonPath("$.records[0].id").value(1))
//                .andExpect(jsonPath("$.records[0].idOrganization").value(1))
//                .andExpect(jsonPath("$.records[0].sku").value("qwer345435"))
//                .andExpect(jsonPath("$.records[0].description").value("produtoDTO inserido"))
//                .andExpect(jsonPath("$.records[0].gtinEan").value("467567567"))
//                .andExpect(jsonPath("$.records[0].processed").value("N"))
//                .andExpect(jsonPath("$.records[0].enabled").value(true));
//    }
//
//    @Test
//    void shouldReturnResponse200WithLinks() throws Exception {
//        final RequestProductDTO product = ConvertUtils
//                .readFileJsonToObject(PATH_JSON + "request-product-link.json", RequestProductDTO.class);
//        this.mockMvc.perform(MockMvcRequestBuilders.post(API_PRODUCT)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(toJson(product))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("utf-8"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.errors").doesNotExist())
//                .andExpect(jsonPath("$.records").exists())
//                .andExpect(jsonPath("$.records[*]").isNotEmpty())
//                .andExpect(jsonPath("$.meta.recordCount").isNumber())
//                .andExpect(jsonPath("$.records").isArray())
//                .andExpect(jsonPath("$.records[0].id").value(1))
//                .andExpect(jsonPath("$.records[0].idOrganization").value(1))
//                .andExpect(jsonPath("$.records[0].sku").value("qwer345435"))
//                .andExpect(jsonPath("$.records[0].description").value("produtoDTO inserido"))
//                .andExpect(jsonPath("$.records[0].gtinEan").value("467567567"))
//                .andExpect(jsonPath("$.records[0].processed").value("N"))
//                .andExpect(jsonPath("$.records[0].enabled").value(true));
//    }
//
//}