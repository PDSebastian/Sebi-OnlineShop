package ro.mycode.sebionlineshop.productCategories.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryRequest;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;
import ro.mycode.sebionlineshop.productCategories.mapper.ProductCategoryMapper;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;
import ro.mycode.sebionlineshop.productCategories.service.ProductCAtegoryQueryService;
import ro.mycode.sebionlineshop.productCategories.service.ProductCategoryCommandService;

@RestController
@RequestMapping("/api/v2/productsCategory")
@Slf4j
public class ProductCaregoryController {
    ProductCategoryCommandService  productCategoryCommandService;
    ProductCAtegoryQueryService  productCAtegoryQueryService;
    public ProductCaregoryController(ProductCategoryCommandService productCategoryCommandService, ProductCAtegoryQueryService productCAtegoryQueryService) {
        this.productCategoryCommandService = productCategoryCommandService;
        this.productCAtegoryQueryService = productCAtegoryQueryService;
    }
    @PostMapping("/add")
    public ResponseEntity<ProductCategoryResponse> addProductCategory(@RequestBody ProductCategoryRequest productCategoryRequest) {
        ProductCategory productCategory = ProductCategoryMapper.toEntity(productCategoryRequest);
        ProductCategoryResponse response = productCategoryCommandService.addProductCategory(productCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }







}
