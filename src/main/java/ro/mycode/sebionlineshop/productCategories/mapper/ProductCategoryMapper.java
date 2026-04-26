package ro.mycode.sebionlineshop.productCategories.mapper;


import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryRequest;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;
import ro.mycode.sebionlineshop.products.model.Product;

public class ProductCategoryMapper {
  public static   ProductCategory toEntity(ProductCategoryRequest productCategoryRequest) {
        if (productCategoryRequest == null) {
            return null;
        }
      Product product = new Product();
      product.setId(productCategoryRequest.productId());

      Category category = new Category();
      category.setId(productCategoryRequest.categoryId());

      return ProductCategory.builder()
              .product(product)
              .category(category).build();

    }

    public static ProductCategoryResponse toDto(ProductCategory productCategory) {
      if (productCategory == null) {
          return null;
      }
      return ProductCategoryResponse.builder()
              .id(productCategory.getId())
                .productId(productCategory.getProduct().getId())
                .categoryId(productCategory.getCategory().getId())
                .build();
    }

}
