package ro.mycode.sebionlineshop.options.mapper;

import ro.mycode.sebionlineshop.options.dtos.OptionRequest;
import ro.mycode.sebionlineshop.options.dtos.OptionResponse;
import ro.mycode.sebionlineshop.options.model.Option;

public class OptionMapper {
    public static Option toEntity(OptionRequest request) {
        if (request == null) return null;

        return Option.builder()
                .optionName(request.name()).build();
    }


    public static OptionResponse toDto(Option option) {
        return new OptionResponse(
                option.getId(),
                option.getOptionName()
        );
        }
}
