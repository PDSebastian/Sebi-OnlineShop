package ro.mycode.sebionlineshop.system.security;

import lombok.AllArgsConstructor;
import ro.mycode.sebionlineshop.costumers.model.Costumer;

@AllArgsConstructor
public enum UserPermissions {

    PRODUCT_ADD("product:add"),
    PRODUCT_DELETE("product:delete"),
    PRODUCT_EDIT("product:edit"),

    COSTUMER_ADD("costumer:add"),
    COSTUMER_DELETE("costumer:delete"),
    COSTUMER_EDIT("costumer:edit");
//
//    ORDER_ADD("order:add"),
//    ORDER_DELETE("order:delete");





    private String permissions;
    public String getPermissions() {
        return permissions;
    }

}
