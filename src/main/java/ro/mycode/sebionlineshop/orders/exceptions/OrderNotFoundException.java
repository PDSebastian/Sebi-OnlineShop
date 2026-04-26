package ro.mycode.sebionlineshop.orders.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super(ErrorConstants.ORDER_NOT_FOUND_EXCEPTION);
    }
}
