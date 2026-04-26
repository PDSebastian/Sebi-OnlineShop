package ro.mycode.sebionlineshop.productOptions.service;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.productOptions.dtos.ProductOptionResponse;
import ro.mycode.sebionlineshop.productOptions.exceptions.ProductOptionNotFoundException;
import ro.mycode.sebionlineshop.productOptions.mapper.ProductOptionMapper;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;
import ro.mycode.sebionlineshop.productOptions.repository.ProductOptionRepository;

import java.util.List;

@Component
public class ProductOptionQueryServiceImpl implements ProductOptionQueryService {
    private final ProductOptionRepository productOptionRepository;
    public ProductOptionQueryServiceImpl(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    @Override
    public List<ProductOptionResponse> getAllProductOptions() {
        List<ProductOption> all = (List<ProductOption>) productOptionRepository.findAll();
        if(all.isEmpty()){
            throw new ProductOptionNotFoundException();
        }
        return all.stream()
                .map(ProductOptionMapper::toDto)
                .toList();
    }

    @Override
    public ProductOptionResponse getProductOptionById(Long id) {
        return productOptionRepository.findById(id)
                .map(ProductOptionMapper::toDto)
                .orElseThrow(() -> new ProductOptionNotFoundException());
    }

    @Override
    public List<ProductOptionResponse> getOptionsByProductId(Long productId) {
        List<ProductOption> options = productOptionRepository.findAllByProductId(productId);
        if(options.isEmpty()){
            throw new ProductOptionNotFoundException();
        }
        return options.stream()
                .map(ProductOptionMapper::toDto)
                .toList();
    }
}
