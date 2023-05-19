package br.com.cod2d.api.usecase.mapper;

import br.com.cod2d.api.domain.dto.softup.ProductResponseDTO;
import br.com.cod2d.api.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoftupProductMap {

    public static Product toProduct(final ProductResponseDTO pro) {
        return Product.builder()
                .description(pro.getProdutoDescricao())
                .sku(pro.getProdutoReferencia())
                .creationDate(new Date())
                .gtinEan(pro.getProdutoCodigoEAN())
                .processed("N")
                .enabled(true)
                .internalCode(pro.getProdutoCodigo())
                .unidade(pro.getProdutoUND())
                .ncm(pro.getNCM())
                .pesoLiq((long) pro.getProdutoPesoLiq())
                .pesoBruto((long) pro.getProdutoPesoBruto())
                .observacao(pro.getProdutoObs())
                .fullDescription(pro.getProdutoDescricaoCompleta())
                .length((long) pro.getProdutoComprimento())
                .width((long) pro.getProdutoLargura())
                .height((long) pro.getProdutoAltura())
                .brand("marca" + pro.getTMarcasCodigo())
                .tagTitle(pro.getProdutoTagTitle())
                .metaTagDescription(pro.getProdutoMetaTagDescription())
                .metaTagKeywords(pro.getProdutoMetaTagKeywords())
                .build();
    }


}
