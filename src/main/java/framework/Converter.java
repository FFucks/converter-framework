package framework;

public interface Converter<S, T> {

    T convert(S source);
}
