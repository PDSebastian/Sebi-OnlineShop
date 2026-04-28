package ro.mycode.sebionlineshop.productOptions.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionRequest;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;
import ro.mycode.sebionlineshop.productOptions.mapper.ProductOptionMapper;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;
import ro.mycode.sebionlineshop.productOptions.service.ProductOptionCommandService;
import ro.mycode.sebionlineshop.productOptions.service.ProductOptionQueryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v2/productOption")
public class ProductOptionController {
    private ProductOptionCommandService productOptionCommandService;
    private ProductOptionQueryService productOptionQueryService;

    public ProductOptionController(ProductOptionCommandService productOptionCommandService, ProductOptionQueryService productOptionQueryService) {
        this.productOptionCommandService = productOptionCommandService;
        this.productOptionQueryService = productOptionQueryService;
    }
    @PostMapping("/add")
    public ResponseEntity<ProductOptionResponse>addProductOption(@Valid @RequestBody ProductOptionRequest productOptionRequest){
        log.debug("http://localhost:8080/api/v2/productOption/add");
        ProductOption productOption = ProductOptionMapper.toEntity(productOptionRequest);
        ProductOptionResponse response = productOptionCommandService.addProductOption(productOption);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductOptionResponse> updateProductOption(@Valid @RequestBody ProductOptionRequest productOptionRequest) {
        log.debug("http://localhost:8080/api/v2/productOption/update");

        ProductOption productOption = ProductOptionMapper.toEntity(productOptionRequest);
        ProductOptionResponse response = productOptionCommandService.updateProductOption(productOption);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProductOption(@RequestBody ProductOptionRequest productOptionRequest) {
        log.debug("http://localhost:8080/api/v2/productOption/delete");
        ProductOption productOption = ProductOptionMapper.toEntity(productOptionRequest);
        productOptionCommandService.deleteProductOption(productOption);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductOptionResponse>> getAllProductOptions() {
        log.debug("");
        List<ProductOptionResponse> responses = productOptionQueryService.getAllProductOptions();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOptionResponse> getProductOptionById(@PathVariable Long id) {
        log.debug("GET request to get product option by id: {}", id);
        ProductOptionResponse response = productOptionQueryService.getProductOptionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductOptionResponse>> getOptionsByProductId(@PathVariable Long productId) {
        log.debug("GET request to get options for product id: {}", productId);
        List<ProductOptionResponse> responses = productOptionQueryService.getOptionsByProductId(productId);
        return ResponseEntity.ok(responses);
    }


}
