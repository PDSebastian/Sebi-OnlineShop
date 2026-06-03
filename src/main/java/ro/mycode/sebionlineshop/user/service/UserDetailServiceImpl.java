package ro.mycode.sebionlineshop.user.service;

import jdk.jfr.Category;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.user.exceptions.UserNotFoundException;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        return (UserDetails) userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
    }
}
