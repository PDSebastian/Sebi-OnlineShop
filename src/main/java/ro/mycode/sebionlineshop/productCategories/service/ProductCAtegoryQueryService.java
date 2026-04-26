package ro.mycode.sebionlineshop.productCategories.service;

import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;

import java.util.List;

public interface ProductCAtegoryQueryService {
    List<ProductCategoryResponse> getAllProductCategories();
    ProductCategoryResponse getProductCategoryById(Long id);
    List<ProductCategoryResponse> getCategoriesByProductId(Long productId);
    List<ProductCategoryResponse> getProductsByCategoryId(Long categoryId);
}
