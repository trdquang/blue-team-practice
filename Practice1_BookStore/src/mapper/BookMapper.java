package mapper;

import dto.BookDTO;
import entity.Book;
import model.BookModel;

public class BookMapper {
    public BookDTO toDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .authorIds(book.getAuthorIds())
                .quantity(book.getQuantity())
                .build();
    }
    public Book modelToEntity(BookModel model){
        return Book.builder()
                .name(model.getName())
                .authorIds(model.getAuthorIds())
                .quantity(model.getQuantity())
                .build();
    }
}
