package ro.mycode.sebionlineshop.categories.mapper;

import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.model.Category;

public class CategoryMapper {
    public static Category toEntity(CategoryRequest categoryRequest) {
        if(categoryRequest == null) return null;
        return Category.builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .build();
    }
public static CategoryResponse toDto(Category category) {
        if(category == null) return null;
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
}

}
