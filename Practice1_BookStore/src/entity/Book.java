package entity;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String id;
    private String name;
    private int quantity;
    private Set<Integer>authorIds;
}
