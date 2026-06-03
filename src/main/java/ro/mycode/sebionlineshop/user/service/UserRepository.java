package ro.mycode.sebionlineshop.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByEmail(String email);
}
