package ro.mycode.sebionlineshop.categories.service.commandService;

import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;

public interface CategoryCommandService {
    CategoryResponse addCategory(CategoryRequest categoryRequest);
    CategoryResponse updateCategory(CategoryRequest categoryRequest);
    CategoryResponse deleteCategory(CategoryRequest categoryRequest);
}
