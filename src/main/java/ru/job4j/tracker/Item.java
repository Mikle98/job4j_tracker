package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(String name, Integer id, LocalDateTime created) {
        this.name = name;
        this.id = id;
        this.created = created;
    }
}