package ro.mycode.sebionlineshop.options.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.options.dtos.OptionRequest;
import ro.mycode.sebionlineshop.options.dtos.OptionResponse;
import ro.mycode.sebionlineshop.options.exceptions.OptionAlreadyExistsException;
import ro.mycode.sebionlineshop.options.exceptions.OptionNotFoundException;
import ro.mycode.sebionlineshop.options.mapper.OptionMapper;
import ro.mycode.sebionlineshop.options.model.Option;
import ro.mycode.sebionlineshop.options.repository.Optionrepository;

@Component
public class OptionCommandServiceImpl implements OptionCommandService {
    Optionrepository optionrepository;
    public OptionCommandServiceImpl(Optionrepository optionrepository) {
        this.optionrepository = optionrepository;
    }
    @Override
    @Transactional
    public OptionResponse addOption(OptionRequest optionRequest) {
        optionrepository.findByOptionName(optionRequest.name()).ifPresent(o -> {
            throw new OptionAlreadyExistsException();
        });
        Option option = OptionMapper.toEntity(optionRequest);
        Option saved = optionrepository.save(option);
        return OptionMapper.toDto(saved);
    }

    @Override
    @Transactional
    public OptionResponse updateOption(OptionRequest optionRequest) {
        Option option = optionrepository.findByOptionName(optionRequest.name())
                .orElseThrow(() -> new OptionNotFoundException());

        option.setOptionName(optionRequest.name());
        Option saved = optionrepository.save(option);
        return OptionMapper.toDto(saved);
    }

    @Override
    @Transactional
    public OptionResponse deleteOption(OptionRequest optionRequest) {
        Option option = optionrepository.findByOptionName(optionRequest.name())
                .orElseThrow(() -> new OptionNotFoundException());

        OptionResponse response = OptionMapper.toDto(option);
        optionrepository.delete(option);
        return response;
    }
}
