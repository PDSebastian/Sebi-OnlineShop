package ro.mycode.sebionlineshop.products.repository;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.products.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @EntityGraph(attributePaths ="productCategories" )
    List<Product> findAll();


    Optional<Product> findBySku(String sku);
}
