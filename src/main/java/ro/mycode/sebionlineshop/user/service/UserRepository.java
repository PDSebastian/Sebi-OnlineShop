package ro.mycode.sebionlineshop.user.service;

import ro.mycode.sebionlineshop.user.model.User;

import java.util.Optional;

public interface UserRepository {
   Optional<User> findByEmail(String email);
}
