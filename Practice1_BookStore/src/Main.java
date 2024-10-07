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
//        List<BookDTO> bookDTOS = bookServiceImplement.getAll();
//        for (BookDTO bk : bookDTOS) {
//            System.out.print(bk.getId() + ", " + bk.getName() + ", " + bk.getQuantity() + "\n");
//            for (int it : bk.getAuthorIds()) {
//                System.out.print(it + ", ");
//            }
//            System.out.println("-------------------------");
//        }
//        Set<Integer> authorIds = new HashSet<>();
//        authorIds.add(1);
//        authorIds.add(2);
//        authorIds.add(3);
//        authorIds.add(4);
//        authorIds.add(5);
//        bookServiceImplement.save(new BookModel("abc", 19, authorIds));
//        List<BookDTO> bookDTOList = bookServiceImplement.getAll();
////        BookDTO bookDTO=bookServiceImplement.findById("2");
////        BookDTO newBook= new BookDTO("2","toán 3",19,authorIds);
////        bookServiceImplement.edit(newBook);
////        List<BookDTO> bookDTOList1= bookServiceImplement.getAll();
////        bookServiceImplement.deleteById("3");
////        List<BookDTO> bookDTOList2= bookServiceImplement.getAll();
        int x = 0;
    }

}