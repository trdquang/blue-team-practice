package service;

import dto.BookDTO;
import entity.Author;
import entity.Book;
import model.BookModel;

import java.io.IOException;
import java.util.List;

public interface IBookService extends BaseService<BookDTO, BookModel> {
//    List<BookDTO> getAllByAuthor(String authorId) throws IOException;
}
