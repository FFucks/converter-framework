package converters;

import framework.Converter;

import java.util.Objects;

public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        if (Objects.isNull(source))
            return null;

        return Integer.parseInt(source);
    }
}
