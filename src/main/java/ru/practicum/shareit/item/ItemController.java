package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserMapper;
import ru.practicum.shareit.user.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * TODO Sprint add-controllers.
 */
@RestController
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/items")
    public List<ItemDto> getItems(@RequestHeader(value = "X-Sharer-User-Id", required = false) Long userId) {
        if (userId == null) {
            return itemService.getAll();
        } else {
            return itemService.getAllForUser(userId);
        }
    }

    @GetMapping("/items/{id}")
    public ItemDto getItemById(@PathVariable("id") long itemId) {
        return itemService.getById(itemId);
    }

    @GetMapping("/items/search")
    public List<ItemDto> getItemsWithSearch(@RequestHeader(value = "X-Sharer-User-Id", required = false) @RequestParam String text) {
        return itemService.getByNameOrDescription(text);
    }

    @PostMapping(value = "/items")
    public ItemDto create(@Valid @RequestBody ItemDto itemDto, @RequestHeader("X-Sharer-User-Id") long userId) {
        User owner = UserMapper.fromUserDto(userService.getById(userId));
        owner.setId(userId);
        itemDto.setOwner(owner);
        itemService.create(itemDto);
        return itemService.getNewest();

    }

    @PatchMapping(value = "/items/{id}")
    public ItemDto update(@Valid @RequestBody ItemDto itemDto, @PathVariable("id") long itemId, @RequestHeader("X-Sharer-User-Id") long userId) {
        itemService.update(itemId, userId, itemDto);
        return itemService.getById(itemId);
    }
}

