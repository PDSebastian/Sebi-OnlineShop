package ro.mycode.sebionlineshop.productOptions.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryAlreadyExistsException;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;
import ro.mycode.sebionlineshop.productOptions.exceptions.ProductOptionNotFoundException;
import ro.mycode.sebionlineshop.productOptions.mapper.ProductOptionMapper;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;
import ro.mycode.sebionlineshop.productOptions.repository.ProductOptionRepository;

@Component
public class ProductOptionCommandServiceImpl implements ProductOptionCommandService {
    private ProductOptionRepository productOptionRepository;

    public ProductOptionCommandServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    @Transactional
    public ProductOptionResponse addProductOption(ProductOption productOption) {
        if (!productOptionRepository.existsById(productOption.getProduct().getId())) {
            throw new ProductCategoryAlreadyExistsException();
        }
        ProductOption saved = productOptionRepository.save(productOption);
        return ProductOptionMapper.toDto(saved);
    }

    @Override
    @Transactional
    public ProductOptionResponse updateProductOption(ProductOption productOption) {
        if (!productOptionRepository.existsById(productOption.getId())) {
            throw new ProductOptionNotFoundException();
        }
        ProductOption updated = productOptionRepository.save(productOption);
        return ProductOptionMapper.toDto(updated);

    }

    @Override
    @Transactional
    public void deleteProductOption(ProductOption productOption) {
        if (!productOptionRepository.existsById(productOption.getId())) {
            throw new ProductOptionNotFoundException();
        }
        productOptionRepository.deleteById(productOption.getId());
    }
}
