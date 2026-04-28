package ro.mycode.sebionlineshop.products.service;

import ro.mycode.sebionlineshop.products.dtos.ProductResponse;

import java.util.List;

public interface ProductQueryService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById( Long id);


}
