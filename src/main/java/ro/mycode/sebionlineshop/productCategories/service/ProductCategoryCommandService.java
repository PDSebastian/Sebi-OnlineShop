package ro.mycode.sebionlineshop.productCategories.service;

import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;

public interface ProductCategoryCommandService {
    ProductCategoryResponse addProductCategory(ProductCategory productCategory);
    ProductCategoryResponse updateProductCategory(ProductCategory productCategory);
    void deleteProductCategory(Long productCategoryId);
}
