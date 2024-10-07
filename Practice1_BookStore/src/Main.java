import dto.AuthorDTO;
import dto.BookDTO;
import dto.OrderDTO;
import dto.UserDTO;
import model.AuthorModel;
import model.UserModel;
import service.IOrderService;
import service.impl.AuthorService;
import service.impl.BookServiceImplement;
import service.impl.OrderService;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
//        BookServiceImplement bookServiceImplement = new BookServiceImplement();
//        List<BookDTO> bookDTOS = bookServiceImplement.getAll();
//        for(BookDTO bk: bookDTOS){
//            System.out.print(bk.getId() + ", " + bk.getName() + ", " + bk.getQuantity() + "\n");
//            for(int it: bk.getAuthorIds()){
//                System.out.print(it + ", ");
//            }
//            System.out.println("-------------------------");
//        }

        AuthorService authorService = new AuthorService();
//        List<AuthorDTO> authorDTOS = authorService.getAll();
//        for(AuthorDTO au: authorDTOS){
//            System.out.println(au.getId() + ", " + au.getName());
//        }
        authorService.saveFlơModal();


    }

}