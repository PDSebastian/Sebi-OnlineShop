package ro.mycode.sebionlineshop.options.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.options.model.Option;

import java.util.Optional;

public interface Optionrepository  extends JpaRepository<Option,Long> {
    Optional<Option> findByOptionName(String optionName);
    Optional<Option> findById(Long id);


}
