package ro.mycode.sebionlineshop.products.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.products.dtos.ProductRequest;
import ro.mycode.sebionlineshop.products.dtos.ProductResponse;
import ro.mycode.sebionlineshop.products.service.ProductCommandService;
import ro.mycode.sebionlineshop.products.service.ProductQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
@Slf4j
public class ProductController {
    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;

    public  ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }
    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductRequest productRequest){
        log.debug("http delete /api/v2/products/delete/{id}");
        ProductResponse savedProduct = productCommandService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);


    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long productId){
        log.debug("http post /api/v2/products/delete/{productId}",productId);
        ProductResponse deletedProduct = productCommandService.deleteProduct(productId);
        return ResponseEntity.ok().body(deletedProduct);
    }
    @PutMapping("/put/products/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductRequest productRequest){
        log.debug("http put /api/v2/products/update/{productId}",productId,productRequest);
        ProductResponse updatedProduct = productCommandService.updateProduct(productRequest);
        return ResponseEntity.ok().body(updatedProduct);

    }
    @PatchMapping("/patch/products/{productId}")
    public ResponseEntity<ProductResponse> patchProduct(@PathVariable Long productId, @RequestBody ProductRequest productRequest){
        log.debug("http patch /api/v2/products/patch/{productId}",productId,productRequest);
        ProductResponse productResponse=productCommandService.updatePatchProduct(productId,productRequest);
        return ResponseEntity.ok().body(productResponse);

    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        log.debug("http get all /api/v2/products");
        List<ProductResponse> products = productQueryService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        ProductResponse product = productQueryService.getProductById(productId);
        return ResponseEntity.ok(product);
    }




}
