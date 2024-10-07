package mapper;

import dto.AuthorDTO;
import dto.UserDTO;
import entity.Author;
import entity.User;
import model.AuthorModel;
import model.UserModel;

public class AuthorMapper {

    public static Author toAuthor(AuthorModel model){
        return Author.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
    public static Author toAuthor1(AuthorDTO model){
        return Author.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
