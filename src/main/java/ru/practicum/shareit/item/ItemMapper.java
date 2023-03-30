package ru.practicum.shareit.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static ItemDto toItemDto(Item item) {
        return new ItemDto(item.getId(),
                item.getName(),
                item.getDescription(),
                item.getAvailable(),
                item.getRequest(),
                item.getOwner());
    }

    public static Item fromItemDto(ItemDto itemDto) {
        return new Item(-1L,
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getAvailable(),
                itemDto.getRequest(),
                itemDto.getOwner());
    }
}
