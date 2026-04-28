package ro.mycode.sebionlineshop.products.service;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.products.dtos.ProductResponse;
import ro.mycode.sebionlineshop.products.exceptions.ProductNotFoundException;
import ro.mycode.sebionlineshop.products.mapper.ProductMapper;
import ro.mycode.sebionlineshop.products.model.Product;
import ro.mycode.sebionlineshop.products.repository.ProductRepository;

import java.util.List;
@Component
public class ProductQueryServiceImpl implements ProductQueryService {
    ProductRepository productRepository;
    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        return ProductMapper.toDto(product);
    }
}
