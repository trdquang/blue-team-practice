package entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private String id;
    private String name;
    private static int size = 0;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Author.size = size;
    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
