package ro.mycode.sebionlineshop.costumers.service.queryService;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.costumers.dtos.CostumerResponse;
import ro.mycode.sebionlineshop.costumers.mapper.CosutmerMapper;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;

import java.util.List;

@Component
public class CosutmerQueryServiceImpl implements CostumerQueryService{
    private CostumerRepository costumerRepository;
    public CosutmerQueryServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;

    }

    @Override
    public List<CostumerResponse> getAllCostumers() {
        return costumerRepository.findAll()
                .stream()
                .map(CosutmerMapper::toDto)
                .toList();
    }

    @Override
    public CostumerResponse getCostumerByEmail(String email) {
        Costumer costumer = costumerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Costumer not found"));
        return CosutmerMapper.toDto(costumer);
    }

    @Override
    public CostumerResponse getCostumerById(Long id) {
        Costumer  costumer=costumerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Costumer not found"));
        return CosutmerMapper.toDto(costumer);
    }
}
