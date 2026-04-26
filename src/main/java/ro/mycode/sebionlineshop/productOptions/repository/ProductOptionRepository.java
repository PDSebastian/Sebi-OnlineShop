package ro.mycode.sebionlineshop.productOptions.repository;

import org.springframework.data.repository.CrudRepository;
import ro.mycode.sebionlineshop.productOptions.model.ProductOption;

import java.util.List;
import java.util.Optional;

public interface ProductOptionRepository extends CrudRepository<ProductOption,Long> {
    List<ProductOption> findAllByProductId(Long productId);
    List<ProductOption> findAllByOptionId(Long optionId);
    boolean existsByProductIdAndOptionId(Long productId, Long optionId);
    Optional<ProductOption> findByProductIdAndOptionId(Long productId, Long optionId);
}
