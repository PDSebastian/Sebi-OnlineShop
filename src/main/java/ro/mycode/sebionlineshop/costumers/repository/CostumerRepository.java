package ro.mycode.sebionlineshop.costumers.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ro.mycode.sebionlineshop.costumers.model.Costumer;

import java.util.List;
import java.util.Optional;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {
    @EntityGraph(attributePaths = "orders")
    Optional<Costumer> findByEmail(String email);

    @EntityGraph(attributePaths = "orders")
    Optional<Costumer> findById(Long id);

    @EntityGraph(attributePaths = "orders")
    List<Costumer> findAll();
}
