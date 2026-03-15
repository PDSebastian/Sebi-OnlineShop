package ro.mycode.sebionlineshop.products.service.commandService;

import ro.mycode.sebionlineshop.products.dtos.ProductRequest;
import ro.mycode.sebionlineshop.products.dtos.ProductResponse;

public interface ProductCommandService {
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse updateProduct(ProductRequest productRequest);
    ProductResponse deleteProduct(ProductRequest productRequest);

}
