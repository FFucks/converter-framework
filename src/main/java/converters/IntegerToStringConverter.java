package converters;

import framework.Converter;

import java.util.Objects;

public class IntegerToStringConverter implements Converter<Integer, String> {

    @Override
    public String convert(Integer source) {
        if (Objects.isNull(source))
            return null;

        return source.toString();
    }
}
