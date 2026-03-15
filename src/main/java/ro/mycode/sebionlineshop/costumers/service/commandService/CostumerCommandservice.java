package ro.mycode.sebionlineshop.costumers.service.commandService;

import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.model.Costumer;

public interface CostumerCommandservice {
    CostumerResponse addCostumer(CostumerRequest costumerRequest);
    CostumerResponse updateCostumer(CostumerRequest costumerRequest);
    CostumerResponse deleteCostumer(CostumerRequest  costumerRequest);
}
