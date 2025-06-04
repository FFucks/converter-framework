package converters;

import framework.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private final DateTimeFormatter formatter;

    public StringToLocalDateConverter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    // Default to YYYY-MM-DD
    public StringToLocalDateConverter() {
        this(DateTimeFormatter.ISO_LOCAL_DATE.toString());
    }

    @Override
    public LocalDate convert(String source) {
        if (source == null || source.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(source, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Failed to parse date string: " + source + " with format: " + formatter, e);
        }
    }
}
