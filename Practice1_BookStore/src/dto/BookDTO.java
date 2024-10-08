package dto;

import entity.Author;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String id;
    private String name;
    private int quantity;
    private int sell;
    private Set<String> authorIds;
}
