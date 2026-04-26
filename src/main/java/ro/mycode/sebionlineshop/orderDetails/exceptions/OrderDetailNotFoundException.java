package ro.mycode.sebionlineshop.orderDetails.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException() {
        super(ErrorConstants.ORDERDETAIL_NOT_FOUND_EXCEPTION);
    }
}
