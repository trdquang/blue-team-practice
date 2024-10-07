package controller;

import dto.BookDTO;
import entity.Book;
import model.BookModel;
import service.IBookService;
import service.impl.BookServiceImplement;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static IBookService bookService;

    static {
        try {
            bookService = new BookServiceImplement();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Set<Integer> authorIds1 = new HashSet<>();
        authorIds1.add(1);
        authorIds1.add(2);
        authorIds1.add(3);
        authorIds1.add(4);
        authorIds1.add(5);
        BookModel bookModel=new BookModel("toan 1",19,authorIds1);
        bookService.save(bookModel);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId("1");
        bookDTO.setName("Toan 2");
        bookDTO.setQuantity(10);
        bookDTO.setAuthorIds(authorIds1);
        bookService.edit(bookDTO);
        bookService.deleteById("1");
        int x = 0;
    }
}
