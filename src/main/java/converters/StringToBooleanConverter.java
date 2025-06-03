package converters;

import framework.Converter;

import java.util.Objects;

public class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String source) {
        if (Objects.isNull(source)) {
            return null;
        }

    }

    @Override
    public Class<String> getSourceType() {
        return String.class;
    }

    @Override
    public Class<Boolean> getTargetType() {
        return Boolean.class;
    }
}
