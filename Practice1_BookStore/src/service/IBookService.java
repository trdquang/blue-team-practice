package service;

import dto.AuthorDTO;
import dto.BookDTO;
import entity.Author;
import entity.Book;
import model.BookModel;

import java.io.IOException;
import java.util.List;

public interface IBookService extends BaseService<BookDTO, BookModel> {
        List<BookDTO> getAllByAuthor(AuthorDTO author) throws IOException;
        void sell(int bookId,int quantity) throws IOException;
}
