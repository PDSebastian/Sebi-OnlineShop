package ro.mycode.sebionlineshop.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerAlreadyExistsException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler( {
                CostumerAlreadyExistsException.class,
                CostumerNotFoundException.class
        })

    public ResponseEntity<ApiErrorResponse>handleBadRequest(RuntimeException e){
        ApiErrorResponse apiErrorResponse=ApiErrorResponse.builder()
                .message(e.getMessage())
                .state(HttpStatus.BAD_REQUEST.value())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }

}
