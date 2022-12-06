package ru.practicum.shareit.item;

import lombok.Data;
import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.user.User;

/**
 * TODO Sprint add-controllers.
 */
@Data
public class Item {
    int id;
    String name;
    String description;
    boolean available;
    ItemRequest request;
    User owner;
}
