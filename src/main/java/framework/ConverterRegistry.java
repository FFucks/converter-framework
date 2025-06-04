package framework;

import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {
    private final Map<String, Converter<?, ?>> converters = new HashMap<>();

    public <S, T> void registerConverter(Class<S> sourceType, Class<T> targetType, Converter<S, T> converter) {
        converters.put(sourceType.getName() + targetType.getName(), converter);
    }

    public <S, T> T convert(S source, Class<T> targetType) {
        String key = source.getClass().getName() + targetType.getName();
        Converter<S, T> converter = (Converter<S, T>) converters.get(key);
        if (converter == null) {
            throw new IllegalArgumentException("No converter registered for " + key);
        }
        return converter.convert(source);
    }
}
