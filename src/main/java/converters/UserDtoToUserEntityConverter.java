package converters;

import dto.UserDto;
import entity.UserEntity;
import framework.ConversionService;
import framework.Converter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserDtoToUserEntityConverter implements Converter<UserDto, UserEntity> {

    private final ConversionService conversionService; // To handle nested conversions (e.g., String to LocalDate)

    // Constructor to inject the ConversionService
    public UserDtoToUserEntityConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UserEntity convert(UserDto source) {
        if (source == null) {
            return null;
        }
        UserEntity target = new UserEntity();
        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());

        if (source.getDateOfBirth() != null && !source.getDateOfBirth().isEmpty()) {
            LocalDate dob = conversionService.convert(source.getDateOfBirth(), LocalDate.class);
            target.setDateOfBirth(dob);
        }
        if (source.getMoneyAmount() != null) {
            BigDecimal amount = conversionService.convert(source.getMoneyAmount(), BigDecimal.class);
            target.setMoneyAmount(amount);
        }

        return target;
    }

    @Override
    public Class<UserDto> getSourceType() {
        return UserDto.class;
    }

    @Override
    public Class<UserEntity> getTargetType() {
        return UserEntity.class;
    }
}
