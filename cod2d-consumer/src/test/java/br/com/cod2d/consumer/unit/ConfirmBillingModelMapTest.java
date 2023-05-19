//package br.com.cod2d.consumer.unit;
//
//import br.com.cod2d.consumer.domain.dto.BatchDTO;
//import br.com.cod2d.consumer.domain.dto.ConfirmBillingDTO;
//import br.com.cod2d.consumer.domain.dto.NfeDTO;
//import br.com.cod2d.consumer.domain.dto.OrderDTO;
//import br.com.cod2d.consumer.unit.config.UnitTestConfig;
//import br.com.cod2d.consumer.usecase.mapper.BillingModelMap;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConfirmBillingModelMapTest extends UnitTestConfig {
//
//  private final BillingModelMap billingModelMap = BillingModelMap.INSTANCE;
//
//  @Test
//  public void givenAValidNfeDateShouldConvertWithSuccess() {
//    final String date = "2022-05-09T15:54:57.000Z";
//    final ConfirmBillingDTO confirmBillingDTO = new ConfirmBillingDTO();
//    confirmBillingDTO.setNfe(NfeDTO.builder()
//            .date(date)
//            .build());
//    final LocalDateTime formattedDate = billingModelMap.getNfeDate(confirmBillingDTO);
//    Assertions.assertNotNull(formattedDate);
//  }
//
//  @Test
//  public void givenANULLNfeDateShouldReturnNUll() {
//    final ConfirmBillingDTO confirmBillingDTO = new ConfirmBillingDTO();
//    confirmBillingDTO.setNfe(NfeDTO.builder()
//            .date(null)
//            .build());
//    final LocalDateTime formattedDate = billingModelMap.getNfeDate(confirmBillingDTO);
//    Assertions.assertNull(formattedDate);
//  }
//
//  @Test
//  public void givenNullNfeObjectShouldReturnNUll() {
//    final ConfirmBillingDTO confirmBillingDTO = new ConfirmBillingDTO();
//    final LocalDateTime formattedDate = billingModelMap.getNfeDate(confirmBillingDTO);
//    Assertions.assertNull(formattedDate);
//  }
//
//  @Test
//  public void getNumEtiquetaFulReturnNUll() {
//    final ConfirmBillingDTO confirmBillingDTO = new ConfirmBillingDTO();
//    final String result = billingModelMap.getNumEtiquetaFull(confirmBillingDTO);
//    Assertions.assertNull(result);
//  }
//
//  @Test
//  public void getNumEtiquetaFulReturnNotNUll() {
//    final ConfirmBillingDTO confirmBillingDTO = new ConfirmBillingDTO();
//    final List<String> listTags = new ArrayList<>();
//    listTags.add("1234");
//    confirmBillingDTO.setBatch(BatchDTO.builder().order(OrderDTO.builder().tags(listTags).build()).build());
//    final String result = billingModelMap.getNumEtiquetaFull(confirmBillingDTO);
//    Assertions.assertEquals(result, "1234");
//  }
//
//  @Test
//  public void getOrderReturnNUll() {
//    final var confirmBillingDTO = ConfirmBillingDTO
//            .builder()
//            .batch(BatchDTO.builder().build())
//            .build();
//    final String result = billingModelMap.getNumEtiquetaFull(confirmBillingDTO);
//    Assertions.assertNull(result);
//  }
//
//  @Test
//  public void getTagReturnNUll() {
//    final var confirmBillingDTO = ConfirmBillingDTO
//            .builder()
//            .batch(BatchDTO.builder().order(OrderDTO.builder().build()).build())
//            .build();
//    final String result = billingModelMap.getNumEtiquetaFull(confirmBillingDTO);
//    Assertions.assertNull(result);
//  }
//}
