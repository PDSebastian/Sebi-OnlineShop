package ro.mycode.sebionlineshop.costumers.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerPatchRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerRequest;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerAlreadyExistsException;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.mapper.CostumerMapper;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;

@Component
public class CostumerCommandServiceImpl implements CostumerCommandservice {
    CostumerRepository costumerRepository;
    public CostumerCommandServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    @Transactional
    public CostumerResponse addCostumer(CostumerRequest costumerRequest) {
        costumerRepository.findByEmail(costumerRequest.email()).ifPresent(c -> {
            throw new CostumerAlreadyExistsException();
        });

        Costumer costumer = CostumerMapper.toEntity(costumerRequest);
        Costumer saved = costumerRepository.save(costumer);

        return CostumerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public CostumerResponse updateCostumer(CostumerRequest costumerRequest) {
        Costumer costumer = costumerRepository.findByEmail(costumerRequest.email())
                .orElseThrow(() -> new CostumerNotFoundException());

        costumer.setFullName(costumerRequest.fullName());
        costumer.setPhone(costumerRequest.phone());
        costumer.setBillingAddress(costumerRequest.billingAddress());
        costumer.setDefaultShippingAddress(costumerRequest.defaultShippingAddress());
        costumer.setCountry(costumerRequest.country());
        costumer.setPassword(costumerRequest.password());
        Costumer updated = costumerRepository.save(costumer);

        return CostumerMapper.toDto(updated);
    }

    @Override
    @Transactional
    public CostumerResponse deleteCostumer(Long  costumerId) {
        Costumer costumer = costumerRepository.findById(costumerId)
                .orElseThrow(() -> new CostumerNotFoundException());

        CostumerResponse response = CostumerMapper.toDto(costumer);
        costumerRepository.delete(costumer);
        return response;
    }
    @Override
    @Transactional
    public CostumerResponse patchCostumer(Long id, CostumerPatchRequest patchRequest) {
        Costumer costumer = costumerRepository.findById(id)
                .orElseThrow(() -> new CostumerNotFoundException());
        if (patchRequest.fullName() != null) {
            costumer.setFullName(patchRequest.fullName());
        }
        if (patchRequest.phone() != null) {
            costumer.setPhone(patchRequest.phone());
        }
        if (patchRequest.billingAddress() != null) {
            costumer.setBillingAddress(patchRequest.billingAddress());
        }
        if (patchRequest.defaultShippingAddress() != null) {
            costumer.setDefaultShippingAddress(patchRequest.defaultShippingAddress());
        }

        Costumer updated = costumerRepository.save(costumer);
        return CostumerMapper.toDto(updated);
    }
}
