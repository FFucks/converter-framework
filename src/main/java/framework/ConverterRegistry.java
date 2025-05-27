package framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterRegistry {

    // Map: (sourceType, targetType) -> Converter instance
    private final Map<ConverterKey, Converter<?, ?>> converters = new ConcurrentHashMap<>();

    /**
     * Registers a converter with the registry.
     *
     * @param converter The converter to register.
     * @param <S> The source type of the converter.
     * @param <T> The target type of the converter.
     */
    public <S, T> void registerConverter(Converter<S, T> converter) {
        ConverterKey key = new ConverterKey(converter.getSourceType(), converter.getTargetType());
        if (converters.containsKey(key)) {
            System.out.println("Warning: Overwriting existing converter for " + key);
        }
        converters.put(key, converter);
    }

    /**
     * Retrieves a converter for the given source and target types.
     *
     * @param sourceType The class of the source type.
     * @param targetType The class of the target type.
     * @param <S> The source type.
     * @param <T> The target type.
     * @return The converter if found, or null otherwise.
     */
    @SuppressWarnings("unchecked")
    public <S, T> Converter<S, T> getConverter(Class<S> sourceType, Class<T> targetType) {
        ConverterKey key = new ConverterKey(sourceType, targetType);
        return (Converter<S, T>) converters.get(key);
    }

    /**
     * Helper class to serve as a key for the converters map.
     */
    private static class ConverterKey {
        private final Class<?> sourceType;
        private final Class<?> targetType;

        public ConverterKey(Class<?> sourceType, Class<?> targetType) {
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ConverterKey that = (ConverterKey) o;
            return sourceType.equals(that.sourceType) &&
                    targetType.equals(that.targetType);
        }

        @Override
        public int hashCode() {
            int result = sourceType.hashCode();
            result = 31 * result + targetType.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "ConverterKey{" +
                    "sourceType=" + sourceType.getName() +
                    ", targetType=" + targetType.getName() +
                    '}';
        }
    }


}
