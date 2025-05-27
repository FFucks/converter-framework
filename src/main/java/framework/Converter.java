package framework;

/**
 * Defines the contract for a type converter.
 *
 * @param <S> The source type.
 * @param <T> The target type.
 */
public interface Converter<S, T> {

    /**
     * Converts an object of type S to an object of type T.
     *
     * @param source The source object to convert.
     * @return The converted object of type T.
     */
    T convert(S source);

    /**
     * Returns the source type that this converter handles.
     *
     * @return The source type.
     */
    Class<S> getSourceType();

    /**
     * Returns the target type that this converter produces.
     *
     * @return The target type.
     */
    Class<T> getTargetType();
}
