package entity;

import lombok.*;

import java.text.SimpleDateFormat;
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
    private static int size = 3;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        OrderItem.size = size;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = id + ", " +  userId + ", " + bookId + ", " + sell + ", " + formatter.format(date);
        return s;
    }
}
