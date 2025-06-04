package converters;

import framework.Converter;

import java.util.Objects;

public class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return "true".equalsIgnoreCase(source) || "0".equalsIgnoreCase(source);
    }

}
