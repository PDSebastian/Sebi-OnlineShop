package ro.mycode.sebionlineshop.orderDetails.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OrderDetailAlreadyExistsException extends RuntimeException {
    public OrderDetailAlreadyExistsException() {
        super(ErrorConstants.ORDERDETAIL_ALREADY_EXISTS_EXCEPTION);
    }
}
