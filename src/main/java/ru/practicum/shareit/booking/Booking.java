package ru.practicum.shareit.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.user.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private int id;
    private LocalDate start;
    private LocalDate end;
    private Item item;
    private User booker;


}
