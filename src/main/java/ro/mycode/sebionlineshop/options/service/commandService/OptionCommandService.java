package ro.mycode.sebionlineshop.options.service.commandService;

import ro.mycode.sebionlineshop.options.dtos.OptionRequest;
import ro.mycode.sebionlineshop.options.dtos.OptionResponse;
import ro.mycode.sebionlineshop.options.model.Option;

public interface OptionCommandService {
    OptionResponse addOption(OptionRequest optionRequest);
    OptionResponse updateOption(OptionRequest optionRequest);
    OptionResponse deleteOption(OptionRequest optionRequest);
}
