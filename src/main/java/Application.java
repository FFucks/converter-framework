import converters.*;
import framework.ConverterRegistry;

public class Application {

    public static void main(String[] args) {

        ConverterRegistry registry = new ConverterRegistry();

        registry.registerConverter(String.class, Integer.class, new StringToIntegerConverter());
        /*registry.registerConverter(new LocalDateToStringConverter());
        registry.registerConverter(new LongToBigDecimalConverter());
        registry.registerConverter(new BigDecimalToLongConverter());*/

        registry.convert("123", Integer.class);


        /*ConversionService conversionService = new DefaultConversionService(registry);

        // Register converters
        // Order matters if converters depend on the conversion service for sub-conversions.
        registry.registerConverter(new StringToLocalDateConverter("dd-MM-yyyy"));
        registry.registerConverter(new LocalDateToStringConverter());
        registry.registerConverter(new LongToBigDecimalConverter());
        registry.registerConverter(new BigDecimalToLongConverter());
        registry.registerConverter(new UserDtoToUserEntityConverter(conversionService));
        registry.registerConverter(new UserEntityToUserDtoConverter(conversionService));

        System.out.println("--- Converting UserDto to UserEntity ---");
        UserDto userDto = new UserDto(1L, "Fabio", "Fucks", "fabio.fucks@gmail.com", "05-12-1988", 1000L);
        System.out.println("Original DTO: " + userDto);

        UserEntity userEntity = conversionService.convert(userDto, UserEntity.class);
        System.out.println("Converted Entity: " + userEntity);
        System.out.println("----------------------------------------\n");

        System.out.println("--- Converting UserEntity to UserDto ---");
        UserEntity anotherUserEntity = new UserEntity(2L, "Renato", "Alcides", "renato.alcides@hotmail.com", LocalDate.of(1954, 7, 25), BigDecimal.valueOf(966000));
        System.out.println("Original Entity: " + anotherUserEntity);

        UserDto anotherUserDto = conversionService.convert(anotherUserEntity, UserDto.class);
        System.out.println("Converted DTO: " + anotherUserDto);
        System.out.println("----------------------------------------\n");

        System.out.println("--- Attempting conversion for unknown type ---");
        try {
            Integer value = conversionService.convert("hello", Integer.class);
            System.out.println("Converted value: " + value);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");*/
    }
}
