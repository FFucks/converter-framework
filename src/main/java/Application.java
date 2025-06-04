import converters.*;
import framework.ConverterRegistry;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        try {
            ConverterRegistry registry = new ConverterRegistry();

            registry.registerConverter(String.class, Integer.class, new StringToIntegerConverter());
            registry.registerConverter(Integer.class,String.class, new IntegerToStringConverter());
            registry.registerConverter(Long.class, BigDecimal.class, new LongToBigDecimalConverter());
            registry.registerConverter(LocalDate.class, String.class, new LocalDateToStringConverter());
            registry.registerConverter(String.class, LocalDate.class, new StringToLocalDateConverter("yyyy-MM-dd"));

            Integer intVal = registry.convert("123", Integer.class);
            System.out.println("Integer Converted: " + intVal + " " + intVal.getClass());

            String stringVal = registry.convert(456, String.class);
            System.out.println("String Converted: " + stringVal + " " + stringVal.getClass());

            BigDecimal bigDecVal = registry.convert(1550000L, BigDecimal.class);
            System.out.println("BigDecimal converted: " + bigDecVal + " " + bigDecVal.getClass());

            String dateStringVal = registry.convert(LocalDate.of(1954, 7, 25), String.class);
            System.out.println("String converted: " + dateStringVal + " " + dateStringVal.getClass());

            LocalDate localDateVal = registry.convert("1988-12-05", LocalDate.class);
            System.out.println("LocalDate converted: " + localDateVal + " " + localDateVal.getClass());

            BigDecimal err = registry.convert(111, BigDecimal.class);

        } catch (IllegalArgumentException e) {
            System.out.println("Error on convertion: " + e.getMessage());
        }

    }
}
