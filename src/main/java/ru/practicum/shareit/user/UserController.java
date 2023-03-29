package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * TODO Sprint add-controllers.
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable("id") Long usersId) {
        return userService.getById(usersId);
    }

    @PostMapping(value = "/users")
    public User create(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PatchMapping(value = "/users/{id}")
    public UserDto update(@PathVariable("id") long usersId, @Valid @RequestBody UserDto userDto) {
        userService.update(usersId, userDto);
        return userService.getById(usersId);
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable("id") long usersId) {
        userService.delete(usersId);
    }
}
