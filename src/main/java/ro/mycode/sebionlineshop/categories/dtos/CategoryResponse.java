package ro.mycode.sebionlineshop.categories.dtos;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Long id,
        String name,
        String description
) {

}
