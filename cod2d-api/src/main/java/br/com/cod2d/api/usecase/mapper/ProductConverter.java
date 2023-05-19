package br.com.cod2d.api.usecase.mapper;

import br.com.cod2d.api.domain.dto.product.ResponseProductDTO;
import br.com.cod2d.api.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class ProductConverter {

    private ProductConverter() {
    }

    public static List<ResponseProductDTO> buildProduct(final List<Product> prod) {
        return prod.stream().map(ProductConverter::buildProduct)
                .collect(Collectors.toList());
    }

    private static ResponseProductDTO buildProduct(final Product prod) {
        return ResponseProductDTO
                .builder()
                .sku(prod.getSku())
                .gtinEan(prod.getGtinEan())
                .build();
    }
}
