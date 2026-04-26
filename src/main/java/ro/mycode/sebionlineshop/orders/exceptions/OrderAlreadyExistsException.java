package ro.mycode.sebionlineshop.orders.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OrderAlreadyExistsException extends RuntimeException {
    public OrderAlreadyExistsException() {
        super(ErrorConstants.ORDER_ALREADY_EXISTS_EXCEPTION);
    }
}
