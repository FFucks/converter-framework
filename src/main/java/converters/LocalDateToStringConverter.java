package converters;

import framework.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateToStringConverter implements Converter<LocalDate, String> {
    @Override
    public String convert(LocalDate source) {
        if (source == null) {
            return null;
        }
        return source.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
