package ro.mycode.sebionlineshop.costumers.service;

import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;

import java.util.List;

public interface CostumerQueryService {
    List<CostumerResponse> getAllCostumers();
    CostumerResponse getCostumerByEmail(String email);
    CostumerResponse getCostumerById(Long id);
}
