package ro.mycode.sebionlineshop.auth.authService;

import ro.mycode.sebionlineshop.user.dtos.UserLoginRequest;
import ro.mycode.sebionlineshop.user.dtos.UserRequest;
import ro.mycode.sebionlineshop.user.dtos.UserResponse;

public interface AuthService {
    UserResponse login(UserLoginRequest userLoginRequest);
    UserResponse register(UserRequest  userRequest);
}
