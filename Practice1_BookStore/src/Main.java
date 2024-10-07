import dto.BookDTO;
import dto.UserDTO;
import model.UserModel;
import service.impl.BookServiceImplement;
import util.FileUtil;

import java.io.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException{
        BookServiceImplement bookServiceImplement = new BookServiceImplement();
        List<BookDTO> bookDTOS = bookServiceImplement.getAll();
        for(BookDTO it: bookDTOS){
            System.out.println(it.getId() + ", " + it.getName());
        }
    }

}