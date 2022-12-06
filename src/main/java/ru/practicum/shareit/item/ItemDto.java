package ru.practicum.shareit.item;

import lombok.Data;
import ru.practicum.shareit.request.ItemRequest;
import ru.practicum.shareit.user.User;

@Data
public class ItemDto {
    int id;
    String name;
    String description;
    boolean available;
    ItemRequest request;
    User owner;
}
