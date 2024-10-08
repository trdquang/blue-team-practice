package dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private String id;
    private String userId;
    private String bookId;
    private int sell;
    private Date date;
    private String userName;
    private String bookName;
}
