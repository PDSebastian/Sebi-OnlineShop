package ro.mycode.sebionlineshop.system.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiErrorResponse(
      String timestamp,
      int status,
      String error,
      String message


) {

    public static ApiErrorResponse of(int status,String timstamp,String error,String message){
        return ApiErrorResponse.of(status,timstamp,error,message);
    }

}
