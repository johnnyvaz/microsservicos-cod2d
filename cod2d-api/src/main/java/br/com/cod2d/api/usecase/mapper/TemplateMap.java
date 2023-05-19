//package br.com.cod2d.api.usecase.mapper;
//
//import br.com.cod2d.api.domain.dto.product.RequestProductDTO;
//import br.com.cod2d.api.domain.model.Client;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring")
//public interface TemplateMap {
//
//    TemplateMap INSTANCE = Mappers.getMapper(TemplateMap.class);
//
//    @Mapping(source = "client.id", target = "id")
//    RequestProductDTO toTemplateDTO(final Client client);
//
//}
