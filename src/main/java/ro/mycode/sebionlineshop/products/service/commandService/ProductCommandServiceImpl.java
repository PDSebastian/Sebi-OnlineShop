package ro.mycode.sebionlineshop.products.service.commandService;

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
        productRepository.findById(productRequest.id())
                .ifPresent(product -> {throw new ProductAlreadyExistsException("Product already exists");});
        Product p= ProductMapper.toEntity(productRequest);
        Product sp= productRepository.save(p);
        return ProductMapper.toDto(sp);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.id())
                .orElseThrow(() ->new ProductNotFoundException("Product not found"));
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
    public ProductResponse deleteProduct(ProductRequest productRequest) {
        Product product=productRepository.findById(productRequest.id())
                .orElseThrow(() ->new ProductNotFoundException("Product not found"));
        ProductResponse response = ProductMapper.toDto(product);
        productRepository.delete(product);
        return response;

    }
}
