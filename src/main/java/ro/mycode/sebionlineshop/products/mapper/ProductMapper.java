package ro.mycode.sebionlineshop.products.mapper;

import ro.mycode.sebionlineshop.products.dtos.ProductRequest;
import ro.mycode.sebionlineshop.products.dtos.ProductResponse;
import ro.mycode.sebionlineshop.products.model.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequest productRequest) {
        if(productRequest == null) return null;
        return Product.builder().sku(productRequest.sku())
                .name(productRequest.name())
                .price(productRequest.price())
                .weight(productRequest.weight())
                .description(productRequest.descriptions())
                .thumbnail(productRequest.thumbnail())
                .image(productRequest.image())
                .category(productRequest.category()).build();


    }
    public static ProductResponse toDto(Product product) {
        if(product == null) return null;
        return new ProductResponse(
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getPrice(),
                product.getWeight(),
                product.getDescription(),
                product.getThumbnail(),
                product.getImage(),
                product.getCategory()
        );
    }

}
