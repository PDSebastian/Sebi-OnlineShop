package ro.mycode.sebionlineshop.productOptions.service;

import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;

public interface ProductOptionCommandService {
    ProductOptionResponse addProductOption(ProductOption productOption);
    ProductOptionResponse updateProductOption(ProductOption productOption);
    void deleteProductOption(ProductOption productOption);

}