package mapper;

import dto.UserDTO;
import entity.User;
import model.UserModel;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .roleId(user.getRoleId())
                .build();
    }

    public static User toEntity(UserModel userModel){
        return User.builder()
                .name(userModel.getName())
                .password(userModel.getPassword())
                .roleId(userModel.getRoleId())
                .build();
    }

    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .roleId(userDTO.getRoleId())
                .build();
    }
}
