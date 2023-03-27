package ru.practicum.shareit.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import ru.practicum.shareit.user.User;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ItemRequestDto {
    @NonNull
    private User owner;

    @NonNull
    @Length(max = 200, min = 1)
    private String description;

    @NonNull
    private Instant createDateTime;

}
