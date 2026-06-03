package ro.mycode.sebionlineshop.auth.authController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.sebionlineshop.auth.authService.AuthService;
import ro.mycode.sebionlineshop.user.dtos.UserLoginRequest;
import ro.mycode.sebionlineshop.user.dtos.UserRequest;
import ro.mycode.sebionlineshop.user.dtos.UserResponse;

@RestController
    @RequestMapping("/api/v2/auth")
@Slf4j
public class AuthController {
    private AuthService authService;
    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;

    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(userRequest));

    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserLoginRequest userLoginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(userLoginRequest));
    }

}
