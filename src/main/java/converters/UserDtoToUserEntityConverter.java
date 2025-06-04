package converters;

import dto.UserDto;
import entity.UserEntity;
import framework.Converter;
import framework.ConverterRegistry;

public class UserDtoToUserEntityConverter implements Converter<UserDto, UserEntity> {

    ConverterRegistry registry = new ConverterRegistry();

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


        return target;
    }
}
