package controller;

import dto.BookDTO;
import entity.Book;
import model.BookModel;
import service.IBookService;
import service.impl.BookServiceImplement;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
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
    }
}
