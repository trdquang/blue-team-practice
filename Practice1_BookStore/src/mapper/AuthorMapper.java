package mapper;

import dto.AuthorDTO;
import dto.UserDTO;
import entity.Author;
import entity.User;
import model.AuthorModel;
import model.UserModel;

public class AuthorMapper {
//    public static AuthorDTO toDTO(Author author){
//        return AuthorDTO.builder()
//                .id(author.getId())
//                .name(author.getName())
//                .build();
//    }
//
//    public static Author toEntity(AuthorModel authorModel){
//        return Author.builder()
//                .name(authorModel.getName())
//                .build();
//    }
//
//    public static Author toEntity(AuthorDTO authorDTO){
//        return Author.builder()
//                .id(authorDTO.getId())
//                .name(authorDTO.getName())
//                .build();
//    }

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
