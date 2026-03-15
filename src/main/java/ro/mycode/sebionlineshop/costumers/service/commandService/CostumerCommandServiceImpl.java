package ro.mycode.sebionlineshop.costumers.service.commandService;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerAlreadyExistsException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.mapper.CosutmerMapper;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;

@Component
public class CostumerCommandServiceImpl implements  CostumerCommandservice {
    CostumerRepository costumerRepository;
    public CostumerCommandServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    @Transactional
    public CostumerResponse addCostumer(CostumerRequest costumerRequest) {
        costumerRepository.findByEmail(costumerRequest.email()).ifPresent(c -> {
            throw new CostumerAlreadyExistsException("Email already exists");
        });

        Costumer costumer = CosutmerMapper.toEntity(costumerRequest);
        Costumer saved = costumerRepository.save(costumer);

        return CosutmerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public CostumerResponse updateCostumer(CostumerRequest costumerRequest) {
        Costumer costumer = costumerRepository.findByEmail(costumerRequest.email())
                .orElseThrow(() -> new CostumerNotFoundException("Costumer not found"));

        costumer.setFullName(costumerRequest.fullName());
        costumer.setPhone(costumerRequest.phone());
        costumer.setBillingAddress(costumerRequest.billingAddress());
        costumer.setDefaultShippingAddress(costumerRequest.defaultShippingAddress());
        costumer.setCountry(costumerRequest.country());
        costumer.setPassword(costumerRequest.password());
        Costumer updated = costumerRepository.save(costumer);

        return CosutmerMapper.toDto(updated);
    }

    @Override
    @Transactional
    public CostumerResponse deleteCostumer(CostumerRequest costumerRequest) {
        Costumer costumer = costumerRepository.findByEmail(costumerRequest.email())
                .orElseThrow(() -> new CostumerNotFoundException("Costumer not found"));
        CostumerResponse response = CosutmerMapper.toDto(costumer);
        costumerRepository.delete(costumer);

        return response;
    }
}
