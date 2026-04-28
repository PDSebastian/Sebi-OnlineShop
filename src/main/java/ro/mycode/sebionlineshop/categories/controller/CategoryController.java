package ro.mycode.sebionlineshop.categories.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.categories.dtos.CategoryRequest;
import ro.mycode.sebionlineshop.categories.dtos.CategoryResponse;
import ro.mycode.sebionlineshop.categories.service.CategoryCommandService;
import ro.mycode.sebionlineshop.categories.service.CategoryQueryService;

@RestController
@RequestMapping("/api/v2/category")
@Slf4j
public class CategoryController {
    private final CategoryCommandService categoryCommandService;
    private final CategoryQueryService categoryQueryService;

    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> addCategory(@Valid  @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse=categoryCommandService.addCategory(categoryRequest);
        log.debug("http post /api/v2/category/add/");
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponse>deleteCategory(@PathVariable Long id) {
        CategoryResponse categoryResponse=categoryCommandService.deleteCategory(id);
        log.debug("http post /api/v2/category/delete/");
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }











}
