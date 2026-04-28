package ro.mycode.sebionlineshop.categories.service;

import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;

import java.util.List;

public interface CategoryQueryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(Long id);

}
