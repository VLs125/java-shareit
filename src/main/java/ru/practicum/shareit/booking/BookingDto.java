package ru.practicum.shareit.booking;

import lombok.Data;
import lombok.NonNull;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.user.User;

import java.time.Instant;

@Data
public class BookingDto {
    @NonNull
    private Instant startDateTime;

    @NonNull
    private Instant endDateTime;

    @NonNull
    private BookingStatus status;

    @NonNull
    private Item item;

    @NonNull
    private User booker;

    public BookingDto() {

    }
}