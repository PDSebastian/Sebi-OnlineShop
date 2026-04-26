package ro.mycode.sebionlineshop.productCategories.repository;

import org.springframework.data.repository.CrudRepository;
import ro.mycode.sebionlineshop.productCategories.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
    List<ProductCategory> findAllByProductId(Long productId);
    List<ProductCategory> findAllByCategoryId(Long categoryId);
    boolean existsByProductIdAndCategoryId(Long productId, Long categoryId);
    Optional<ProductCategory> findByProductIdAndCategoryId(Long productId, Long categoryId);
}
