package ro.mycode.sebionlineshop.user.mapper;


import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.user.dtos.UserRequest;
import ro.mycode.sebionlineshop.user.dtos.UserResponse;
import ro.mycode.sebionlineshop.user.model.User;

@Component
public class UserMapper {
    public static User toEntity(UserRequest userRequest) {
        if(userRequest == null) return null;
        return User.builder()
                .firstName(userRequest.firstname())
                .lastName(userRequest.lastname())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }
    public static UserResponse toDto(User user, String token){
        if(user == null) return null;
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                token



        );







    }





}
