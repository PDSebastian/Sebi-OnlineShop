package ro.mycode.sebionlineshop.options.service.queryService;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.options.dtos.OptionResponse;
import ro.mycode.sebionlineshop.options.exceptions.OptionNotFoundException;
import ro.mycode.sebionlineshop.options.mapper.OptionMapper;
import ro.mycode.sebionlineshop.options.model.Option;
import ro.mycode.sebionlineshop.options.repository.Optionrepository;

import java.util.List;

@Component
public class OptionQueryServiceImpl implements OptionQueryService {
    Optionrepository optionrepository;
    public OptionQueryServiceImpl(Optionrepository optionrepository) {
        this.optionrepository = optionrepository;
    }
    @Override
    public List<OptionResponse> getAllOptions() {
        return optionrepository.findAll()
                .stream()
                .map(OptionMapper::toDto)
                .toList();
    }

    @Override
    public OptionResponse getOptionById(Long id) {
        Option option = optionrepository.findById(id)
                .orElseThrow(() -> new OptionNotFoundException("Option not found"));
        return OptionMapper.toDto(option);
    }

    @Override
    public OptionResponse getOptionByName(String name) {
        Option option = optionrepository.findByOptionName(name)
                .orElseThrow(() -> new OptionNotFoundException("Option not found"));
        return OptionMapper.toDto(option);
    }
}
