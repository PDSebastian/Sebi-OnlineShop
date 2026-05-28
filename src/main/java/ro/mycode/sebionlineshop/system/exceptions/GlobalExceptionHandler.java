package ro.mycode.sebionlineshop.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.mycode.sebionlineshop.categories.exceptions.CategoryNotFoundException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerAlreadyExistsException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.options.exceptions.OptionAlreadyExistsException;
import ro.mycode.sebionlineshop.options.exceptions.OptionNotFoundException;
import ro.mycode.sebionlineshop.orderDetails.exceptions.OrderDetailAlreadyExistsException;
import ro.mycode.sebionlineshop.orderDetails.exceptions.OrderDetailNotFoundException;
import ro.mycode.sebionlineshop.orders.exceptions.OrderAlreadyExistsException;
import ro.mycode.sebionlineshop.orders.exceptions.OrderNotFoundException;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryAlreadyExistsException;
import ro.mycode.sebionlineshop.productCategories.exceptions.ProductCategoryNotFoundException;
import ro.mycode.sebionlineshop.productOptions.exceptions.ProductOptionAlreadyExistsException;
import ro.mycode.sebionlineshop.productOptions.exceptions.ProductOptionNotFoundException;
import ro.mycode.sebionlineshop.products.exceptions.ProductAlreadyExistsException;
import ro.mycode.sebionlineshop.products.exceptions.ProductNotFoundException;
import ro.mycode.sebionlineshop.user.exceptions.UserAlreadyExistsException;
import ro.mycode.sebionlineshop.user.exceptions.UserNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler( {
                CostumerAlreadyExistsException.class,
                CostumerAlreadyExistsException.class,
                OptionAlreadyExistsException.class,
                ProductAlreadyExistsException.class,
                OrderDetailAlreadyExistsException.class,
                OrderAlreadyExistsException.class,
                ProductCategoryAlreadyExistsException.class,
                ProductOptionAlreadyExistsException.class,
                UserAlreadyExistsException.class,


        })

    public ResponseEntity<ApiErrorResponse>handleBadRequest(RuntimeException e){
        ApiErrorResponse apiErrorResponse=ApiErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }
     @ExceptionHandler({
            CategoryNotFoundException.class,
            CostumerNotFoundException.class,
             OptionNotFoundException.class,
             ProductNotFoundException.class,
             OrderDetailNotFoundException.class,
             OrderNotFoundException.class,
             ProductCategoryNotFoundException.class,
             ProductOptionNotFoundException.class,
             UserNotFoundException.class

        })
    public ResponseEntity<ApiErrorResponse>handleNotFound(RuntimeException e){
            ApiErrorResponse apiErrorResponse=ApiErrorResponse.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
     }



}
