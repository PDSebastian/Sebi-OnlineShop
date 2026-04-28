package ro.mycode.sebionlineshop.costumers.service;

import ro.mycode.sebionlineshop.costumers.dtos.CostumerPatchRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;

public interface CostumerCommandservice {
    CostumerResponse addCostumer(CostumerRequest costumerRequest);
    CostumerResponse updateCostumer(CostumerRequest costumerRequest);
    CostumerResponse deleteCostumer(Long costumerId);
    CostumerResponse patchCostumer(Long id, CostumerPatchRequest costumerPatchRequest);
}
