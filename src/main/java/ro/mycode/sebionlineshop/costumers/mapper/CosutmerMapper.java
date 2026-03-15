package ro.mycode.sebionlineshop.costumers.mapper;

import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.model.Costumer;

public class CosutmerMapper {
    public static Costumer toEntity(CostumerRequest costumerRequest) {
        if(costumerRequest == null) return null;
        return Costumer.builder()
                .email(costumerRequest.email())
                .password(costumerRequest.password())
                .billingAddress(costumerRequest.billingAddress())
                .defaultShippingAddress(costumerRequest.defaultShippingAddress())
                .phone(costumerRequest.phone())
                .country(costumerRequest.country())
                .fullName(costumerRequest.fullName())
                .build();
    }
    public static CostumerResponse toDto(Costumer costumer) {
        if(costumer == null) return null;
        return new CostumerResponse(
                costumer.getId(),
                costumer.getEmail(),
                costumer.getPassword(),
                costumer.getFullName(),
                costumer.getBillingAddress(),
                costumer.getDefaultShippingAddress(),
                costumer.getPhone(),
                costumer.getCountry()
        );
    }
}
