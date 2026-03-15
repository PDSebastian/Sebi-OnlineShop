package ro.mycode.sebionlineshop.products.dtos;
import lombok.Builder;

@Builder
public record ProductResponse(
     Long id,
    String sku,
    String name,
    Integer price,
    Integer weight,
    String descriptions,
    String thumbnail,
    String image,
    String category


) {
}



