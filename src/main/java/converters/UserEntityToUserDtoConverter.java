package converters;

import dto.UserDto;
import entity.UserEntity;
import framework.Converter;

public class UserEntityToUserDtoConverter implements Converter<UserEntity, UserDto> {

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


        return target;
    }
}
