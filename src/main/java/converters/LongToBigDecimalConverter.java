package converters;

import framework.Converter;

import java.math.BigDecimal;
import java.util.Objects;

public class LongToBigDecimalConverter implements Converter<Long, BigDecimal> {

    @Override
    public BigDecimal convert(Long source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return BigDecimal.valueOf(source);
    }
}
