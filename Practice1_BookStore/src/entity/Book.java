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
    private Set<Author>authors;


    @Override
    public String toString() {
        return id + ", " + name;
    }
}
