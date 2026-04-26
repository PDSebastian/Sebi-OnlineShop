package ro.mycode.sebionlineshop.productCategories.service;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryNotFoundException;
import ro.mycode.sebionlineshop.productCategories.mapper.ProductCategoryMapper;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;
import ro.mycode.sebionlineshop.productCategories.repository.ProductCategoryRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
public class ProductCategoryQueryServiceImpl implements ProductCAtegoryQueryService{
    private final ProductCategoryRepository productCategoryRepository;
    public ProductCategoryQueryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    public List<ProductCategoryResponse> getAllProductCategories() {
       List<ProductCategory> productCategories=(List<ProductCategory>) productCategoryRepository.findAll();
       if(productCategories.isEmpty()){
           throw new ProductCategoryNotFoundException();
       }
       return productCategories.stream().map(ProductCategoryMapper::toDto).toList();
    }

    @Override
    public ProductCategoryResponse getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id)
                .map(ProductCategoryMapper::toDto)
                .orElseThrow(() -> new ProductCategoryNotFoundException());
    }

    @Override
    public List<ProductCategoryResponse> getCategoriesByProductId(Long productId) {
        List<ProductCategory> categories = productCategoryRepository.findAllByProductId(productId);
        if(categories.isEmpty()){
            throw new ProductCategoryNotFoundException();
        }
        return categories.stream().map(ProductCategoryMapper::toDto).toList();

    }

    @Override
    public List<ProductCategoryResponse> getProductsByCategoryId(Long categoryId) {
        List<ProductCategory> products = productCategoryRepository.findAllByCategoryId(categoryId);
        if (products.isEmpty()) {
            throw new ProductCategoryNotFoundException();
        }
        return products.stream().map(ProductCategoryMapper::toDto).toList();
    }
}
