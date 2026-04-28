package ro.mycode.sebionlineshop.costumers.dtos;

import lombok.Builder;

@Builder
public record CostumerPatchRequest(
        String fullName,
        String phone,
        String billingAddress,
        String defaultShippingAddress



) {
}
