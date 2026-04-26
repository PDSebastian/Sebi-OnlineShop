package ro.mycode.sebionlineshop.productCategories.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryRequest;
import ro.mycode.sebionlineshop.productCategories.dtos.ProductCategoryResponse;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryAlreadyExistsException;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryNotFoundException;
import ro.mycode.sebionlineshop.productCategories.mapper.ProductCategoryMapper;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;
import ro.mycode.sebionlineshop.productCategories.repository.ProductCategoryRepository;

@Component
public class ProductCategoryCommandServiceImpl implements ProductCategoryCommandService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryCommandServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    @Transactional
    public ProductCategoryResponse addProductCategory(ProductCategory productCategory) {
        if (productCategoryRepository.existsByProductIdAndCategoryId(
                productCategory.getProduct().getId(),
                productCategory.getCategory().getId())) {
            throw new ProductCategoryAlreadyExistsException();
        }

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return ProductCategoryMapper.toDto(savedProductCategory);
    }

    @Override
    @Transactional
    public ProductCategoryResponse updateProductCategory(ProductCategory productCategory) {
        if(!productCategoryRepository.existsById(productCategory.getProduct().getId())) {
            throw new ProductCategoryNotFoundException();

        }
        ProductCategory updated = productCategoryRepository.save(productCategory);
        return ProductCategoryMapper.toDto(updated);
    }

    @Override
    @Transactional
    public void deleteProductCategory(Long productCategoryId) {
        if (!productCategoryRepository.existsById(productCategoryId)) {
            throw new ProductCategoryNotFoundException();
        }
        productCategoryRepository.deleteById(productCategoryId);
    }
}
