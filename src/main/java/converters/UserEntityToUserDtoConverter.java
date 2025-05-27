package converters;

import dto.UserDto;
import entity.UserEntity;
import framework.ConversionService;
import framework.Converter;

public class UserEntityToUserDtoConverter implements Converter<UserEntity, UserDto> {

    private final ConversionService conversionService; // To handle nested conversions (e.g., LocalDate to String)

    public UserEntityToUserDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UserDto convert(UserEntity source) {
        if (source == null) {
            return null;
        }
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());

        if (source.getDateOfBirth() != null) {
            String date = conversionService.convert(source.getDateOfBirth(), String.class);
            target.setDateOfBirth(date);
        }
        if (source.getMoneyAmount() != null) {
            Long moneyValue = conversionService.convert(source.getMoneyAmount(), Long.class);
            target.setMoneyAmount(moneyValue);
        }

        return target;
    }

    @Override
    public Class<UserEntity> getSourceType() {
        return UserEntity.class;
    }

    @Override
    public Class<UserDto> getTargetType() {
        return UserDto.class;
    }
}
