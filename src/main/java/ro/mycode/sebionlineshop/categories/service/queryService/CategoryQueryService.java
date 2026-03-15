package ro.mycode.sebionlineshop.categories.service.queryService;

import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;

import java.util.List;

public interface CategoryQueryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(Long id);

}
