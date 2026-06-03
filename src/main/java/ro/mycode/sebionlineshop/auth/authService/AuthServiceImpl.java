package ro.mycode.sebionlineshop.auth.authService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.system.jwt.JWTTokenProvider;
import ro.mycode.sebionlineshop.system.security.UserPermissions;
import ro.mycode.sebionlineshop.user.dtos.UserLoginRequest;
import ro.mycode.sebionlineshop.user.dtos.UserRequest;
import ro.mycode.sebionlineshop.user.dtos.UserResponse;
import ro.mycode.sebionlineshop.user.exceptions.UserAlreadyExistsException;
import ro.mycode.sebionlineshop.user.exceptions.UserNotFoundException;
import ro.mycode.sebionlineshop.user.mapper.UserMapper;
import ro.mycode.sebionlineshop.user.model.User;
import ro.mycode.sebionlineshop.user.service.UserRepository;


import java.util.Set;

@Component
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public  AuthServiceImpl(UserRepository userRepository,UserMapper userMapper,AuthenticationManager authenticationManager,JWTTokenProvider jwtTokenProvider,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public UserResponse login(UserLoginRequest userLoginrequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginrequest.email(), userLoginrequest.password())
        );
        User user = userRepository.findByEmail(userLoginrequest.email())
                .orElseThrow(() -> new UserNotFoundException());

        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                jwtTokenProvider.generateToken( user)

        );
    }
    @Override
    public UserResponse register(UserRequest userRequest) {
       if(userRepository.findByEmail(userRequest.email()).isPresent()){
           throw new UserAlreadyExistsException();
       }
       User user=userMapper.toEntity(userRequest);
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPermissions(Set.of(UserPermissions.PRODUCT_ADD,UserPermissions.PRODUCT_EDIT,UserPermissions.PRODUCT_DELETE));
       User savedUser= userRepository.save(user);

       String token = jwtTokenProvider.generateToken(savedUser);
       return userMapper.toDto(savedUser,token);


    }
}
