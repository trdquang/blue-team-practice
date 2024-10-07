package model;

import entity.Author;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookModel {
    private String name;
    private int quantity;
    private Set<Integer> authorIds;
}
