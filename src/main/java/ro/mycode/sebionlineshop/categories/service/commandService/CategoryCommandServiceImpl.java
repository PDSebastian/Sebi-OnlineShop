package ro.mycode.sebionlineshop.categories.service.commandService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryAlreadyexistsException;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.categories.mapper.CategoryMapper;
import ro.mycode.sebionlineshop.categories.model.Category;
import ro.mycode.sebionlineshop.categories.repository.CategoryRepository;

@Component
public class CategoryCommandServiceImpl implements CategoryCommandService {
    CategoryRepository categoryRepository;
    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        categoryRepository.findByName(categoryRequest.name())
                .ifPresent(category -> {throw new CategoryAlreadyexistsException("category already exists");
                });
        Category category = CategoryMapper.toEntity(categoryRequest);
        Category c= categoryRepository.save(category);
        return CategoryMapper.toDto(c);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(CategoryRequest categoryRequest) {
        Category category = categoryRepository.findByName(categoryRequest.name())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found:"));
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        categoryRepository.save(category);
        return CategoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public CategoryResponse deleteCategory(CategoryRequest categoryRequest) {
       Category c=categoryRepository.findByName(categoryRequest.name())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found:"));
       categoryRepository.delete(c);
        return CategoryMapper.toDto(c);

    }
}
