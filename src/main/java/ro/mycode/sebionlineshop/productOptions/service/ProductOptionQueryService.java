package ro.mycode.sebionlineshop.productOptions.service;

import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;

import java.util.List;

public interface ProductOptionQueryService {
    List<ProductOptionResponse> getAllProductOptions();
    ProductOptionResponse getProductOptionById(Long id);
    List<ProductOptionResponse> getOptionsByProductId(Long productId);
}
