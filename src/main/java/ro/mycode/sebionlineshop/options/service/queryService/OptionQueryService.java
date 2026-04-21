package ro.mycode.sebionlineshop.options.service.queryService;

import ro.mycode.sebionlineshop.options.dtos.OptionResponse;

import java.util.List;

public interface OptionQueryService {
    List<OptionResponse> getAllOptions();
    OptionResponse getOptionById(Long id);
    OptionResponse getOptionByName(String name);
}
