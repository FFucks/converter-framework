package framework;

public interface ConversionService {

    /**
     * Converts the given source object to the specified target type.
     *
     * @param source The source object to convert.
     * @param targetType The class of the target type.
     * @param <S> The source type.
     * @param <T> The target type.
     * @return The converted object.
     * @throws IllegalArgumentException If no suitable converter is found.
     */
    <S, T> T convert(S source, Class<T> targetType);
}
