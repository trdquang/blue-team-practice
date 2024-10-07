package mapper;

import dto.BookDTO;
import entity.Book;
import model.BookModel;

public class BookMapper {
    public BookDTO toDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .authorIds(book.getAuthors())
                .quantity(book.getQuantity())
                .build();
    }
    public Book modelToEntity(BookModel model){
        return Book.builder()
                .name(model.getName())
                .authors(model.getAuthorIds())
                .quantity(model.getQuantity())
                .build();
    }
}
