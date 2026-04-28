package ro.mycode.sebionlineshop.options.service;

import ro.mycode.sebionlineshop.options.dtos.OptionRequest;
import ro.mycode.sebionlineshop.options.dtos.OptionResponse;

public interface OptionCommandService {
    OptionResponse addOption(OptionRequest optionRequest);
    OptionResponse updateOption(OptionRequest optionRequest);
    OptionResponse deleteOption(OptionRequest optionRequest);
}
