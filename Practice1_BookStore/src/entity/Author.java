package entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private String id;
    private String name;
    private List<Book> bookList;

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
