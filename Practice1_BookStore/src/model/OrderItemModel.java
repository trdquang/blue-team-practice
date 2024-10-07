package model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemModel {
    private String userId;
    private String bookId;
    private int sell;
    private Date date;


}
