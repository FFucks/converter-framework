package framework;


import java.util.Objects;

public class DefaultConversionService implements ConversionService {

    private final ConverterRegistry converterRegistry;

    public DefaultConversionService(ConverterRegistry converterRegistry) {
        this.converterRegistry = Objects.requireNonNull(converterRegistry);
    }

    @Override
    public <S, T> T convert(S source, Class<T> targetType) {
        if (source == null) {
            return null; // Or throw IllegalArgumentException, depending on desired behavior
        }

        // Handle identity conversion (source type is same as target type)
        if (targetType.isAssignableFrom(source.getClass())) {
            return targetType.cast(source);
        }

        @SuppressWarnings("unchecked")
        Converter<S, T> converter = (Converter<S, T>) converterRegistry.getConverter(source.getClass(), targetType);

        if (converter == null) {
            throw new IllegalArgumentException(
                    "No converter found from " + source.getClass().getName() + " to " + targetType.getName()
            );
        }

        return converter.convert(source);
    }
}
