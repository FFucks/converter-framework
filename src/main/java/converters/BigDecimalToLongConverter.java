package converters;

import framework.Converter;

import java.math.BigDecimal;

public class BigDecimalToLongConverter implements Converter<BigDecimal, Long> {

    @Override
    public Long convert(BigDecimal source) {
        if (source == null) {
            return null;
        }
        return source.longValue();
    }
}
