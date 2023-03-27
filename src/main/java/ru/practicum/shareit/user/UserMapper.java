package ru.practicum.shareit.user;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static User fromUserDto(UserDto userDto) {
        return new User(-1L, userDto.getName(), userDto.getEmail());
    }
}
