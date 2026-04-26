package ro.mycode.sebionlineshop.productOptions.mapper;

import ro.mycode.sebionlineshop.options.model.Option;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionRequest;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;
import ro.mycode.sebionlineshop.products.model.Product;

public class ProductOptionMapper {
    public static ProductOption toEntity(ProductOptionRequest productOptionRequest) {
      if(productOptionRequest == null){
          return null;
      }
        Product product = Product.builder()
                .Id(productOptionRequest.productId())
                .build();

        Option option = Option.builder()
                .id(productOptionRequest.optionId())
                .build();

        return ProductOption.builder()
                .product(product)
                .option(option)
                .build();
    }
    public static ProductOptionResponse toDto(ProductOption productOption) {
        if (productOption == null) {
            return null;
        }

        return ProductOptionResponse.builder()
                .id(productOption.getId())
                .productId(productOption.getProduct().getId())
                .optionId(productOption.getOption().getId())
                .build();
    }

}
