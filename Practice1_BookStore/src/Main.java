import dto.AuthorDTO;
import dto.BookDTO;
import dto.OrderDTO;
import dto.UserDTO;
import model.BookModel;
import model.UserModel;
import service.IOrderService;
import service.impl.AuthorService;
import service.impl.BookServiceImplement;
import service.impl.OrderService;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {
        BookServiceImplement bookServiceImplement = new BookServiceImplement();
        AuthorService authorService=new AuthorService();
        List<AuthorDTO> getAllAuthor=authorService.getAll();
        List<BookDTO> getAllByAuthor=bookServiceImplement.getAllByAuthor(authorService.findById(String.valueOf(2)));
        bookServiceImplement.sell(2,10);
        List<BookDTO> getAll=bookServiceImplement.getAll();

        int x = 0;
    }

}