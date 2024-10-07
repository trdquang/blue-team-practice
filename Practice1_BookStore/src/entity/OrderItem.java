package entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderItem {
    private String id;
    private String userId;
    private String bookId;
    private int sell;
    private Date date;
}
