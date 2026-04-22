package ro.mycode.sebionlineshop.system.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiErrorResponse(
        int state,
        String message,
        LocalDateTime dateTime
) {
}
