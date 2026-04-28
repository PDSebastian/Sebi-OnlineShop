package ro.mycode.sebionlineshop.products.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.products.dtos.ProductRequest;
import ro.mycode.sebionlineshop.products.dtos.ProductResponse;
import ro.mycode.sebionlineshop.products.exceptions.ProductAlreadyExistsException;
import ro.mycode.sebionlineshop.products.exceptions.ProductNotFoundException;
import ro.mycode.sebionlineshop.products.mapper.ProductMapper;
import ro.mycode.sebionlineshop.products.model.Product;
import ro.mycode.sebionlineshop.products.repository.ProductRepository;
@Component
public class ProductCommandServiceImpl implements ProductCommandService {
    ProductRepository productRepository;
    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    @Transactional
    public ProductResponse addProduct(ProductRequest productRequest) {

        productRepository.findBySku(productRequest.sku())
                .ifPresent(product -> {
                    throw new ProductAlreadyExistsException();
                });

        Product p = ProductMapper.toEntity(productRequest);
        Product sp = productRepository.save(p);
        return ProductMapper.toDto(sp);
    }
    @Override
    @Transactional
    public ProductResponse updateProduct(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.id())
                .orElseThrow(() ->new ProductNotFoundException());
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setWeight(productRequest.weight());
        product.setDescription(productRequest.descriptions());
        product.setThumbnail(productRequest.thumbnail());
        product.setImage(productRequest.image());
        product.setCategory(productRequest.category());
        Product p = productRepository.save(product);
        return ProductMapper.toDto(productRepository.save(product));


    }

    @Override
    @Transactional
    public ProductResponse deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException());
        ProductResponse response = ProductMapper.toDto(product);
        productRepository.delete(product);
        return response;

    }

    @Override
    @Transactional
    public ProductResponse updatePatchProduct(Long productId, ProductRequest productRequest) {
        Product product=productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException());
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
       ProductResponse response = ProductMapper.toDto(productRepository.save(product));
       return response;


    }
}
