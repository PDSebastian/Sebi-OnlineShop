package ro.mycode.sebionlineshop.categories.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.categories.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @EntityGraph(attributePaths = "productCategories")
    List<Category> findAll();

    @EntityGraph(attributePaths = "productCategories")
    Optional<Category> findByName(String name);
    Optional<Category> findById(Long id);
}
