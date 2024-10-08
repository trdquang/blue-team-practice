package entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public static int size = 10;
    private String id;
    private String name;
    private String password;
    private String roleId;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        User.size = size;
    }

    @Override
    public String toString() {
        String res = id + ", " + name + ", " + password + ", " + roleId;
        return res;
    }
}
