package controller;

import dto.AuthorDTO;
import dto.BookDTO;
import dto.OrderDTO;
import dto.UserDTO;
import entity.Book;
import model.BookModel;
import model.UserModel;
import service.IBookService;
import service.impl.AuthorService;
import service.impl.BookServiceImplement;
import service.impl.OrderService;
import service.impl.UserService;
import util.FileUtil;
import util.FuntionUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //-------------------define static
    private static UserService userService = new UserService();
    private static OrderService orderService = new OrderService();
    private static AuthorService authorService;
    private static BookServiceImplement bookService;

    static {
        try {
            authorService = new AuthorService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            bookService = new BookServiceImplement();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    private int chooseAdminManage = -1;


    //---------------------------admin user
    public static void adminUser() throws IOException {
        while (true) {
            Menu.menuAdminUser();
            System.out.print("Choose mange-user >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            switch (chooseMenu) {
                case 0:
                    return;
                case 1:
                    List<UserDTO> userDTOS = userService.getAll();
                    System.out.printf(
                            "%-10s, %-15s, %-15s, %-10s\n",
                            "Id", "name", "pass", "role");
                    for (UserDTO it : userDTOS) {
                        System.out.printf(
                                "%-10s, %-15s, %-15s, %-10s\n",
                                it.getId(), it.getName(), it.getPassword(), it.getRoleId());
                    }
                    break;
                case 2:
                    UserModel us = userService.inputOne();
                    userService.save(us);
                    break;
                case 3:
                    System.out.print("User wanto edit >>>");
                    String idEdit = sc.nextLine();
                    UserDTO userEdit = userService.findById(idEdit);
                    if(userEdit == null)
                        System.out.println("User not found");
                    else
                        userService.edit(userEdit);
                    break;
                case 4:
                    System.out.print("User wanto delete >>>");
                    String idDelete = sc.nextLine();
                    userService.deleteById(idDelete);
                    break;

            }
        }
    }

    //--------------------------------------admin order
    public static void adminOrder() throws IOException {
        while (true) {
            Menu.menuAdminOrder();
            System.out.print("Choose mange-order >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            switch (chooseMenu) {
                case 0:
                    return;
                case 1:
                    List<OrderDTO> orderDTOS = orderService.getAll();
                    System.out.printf(
                            "%-10s, %-15s, %-15s, %-10s, %-15s\n",
                            "Id", "User name", "Book name", "quantity", "date");
                    for (OrderDTO it : orderDTOS) {
                        System.out.printf(
                                "%-10s, %-15s, %-15s, %-10s, %-15s\n",
                                it.getId() , it.getUserName(), it.getBookId()+", " + it.getBookName(), it.getSell(), formatter.format(it.getDate()));
                    }
                    break;
                case 2:
                    orderService.groupByName();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.print("User wanto delete >>>");
                    String idDelete = sc.nextLine();
                    orderService.deleteById(idDelete);
                    break;
            }
        }
    }

    //-----------------------manager author
    public static void adminAuthor() throws IOException {
        while (true) {
            Menu.menuAdminAuthor();
            System.out.print("Choose mange-order >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            switch (chooseMenu) {
                case 0:
                    return;
                case 1:
                    List<AuthorDTO> authorDTOS = authorService.getAll();
                    System.out.printf(
                            "%-10s, %-15s\n",
                            "Id", "author name");
                    for (AuthorDTO it : authorDTOS) {
                        System.out.printf(
                                "%-10s, %-15s\n",
                                it.getId() , it.getName());
                    }
                    break;
                case 2:
                    authorService.saveFlowName();
                    break;
                case 3:
                    authorService.EditEntity();
                    break;
                case 4:
                    System.out.print("User wanto delete >>>");
                    String idDelete = sc.nextLine();
                    authorService.deleteById(idDelete);
                    break;
                case 5:
                    authorService.showBooksByAuthor();
                    break;
            }
        }
    }

    //----------------------manage book
    public static void adminBook() throws IOException {
        while (true) {
            Menu.menuAdminBook();
            System.out.print("Choose mange-book >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            switch (chooseMenu) {
                case 0:
                    return;
                case 1:
                    List<BookDTO> bookDTOS = bookService.getAll();
                    System.out.printf(
                            "%-10s, %-15s, %-15s\n",
                            "Id", "name", "quantity");
                    for (BookDTO it : bookDTOS) {
                        System.out.printf(
                                "%-10s, %-15s, %-15d\n",
                                it.getId() , it.getName(), it.getQuantity());
                    }
                    break;
                case 2:
                    System.out.print("Name >>");
                    String name = sc.nextLine();
                    System.out.print("Quantity >>");
                    Integer quantity = FuntionUtil.inputOneNum();
                    Set<Integer> setList = new HashSet<>();
                    setList.add(1);
                    BookModel bk = new BookModel(name, quantity, setList);
                    bookService.save(bk);
                    break;
                case 3:
                    System.out.print("Id to edit >>");
                    String idToEdit = sc.nextLine();
                    BookDTO bookDTOEdit = bookService.findById(idToEdit);
                    bookService.edit(bookDTOEdit);
                    break;
                case 4:
                    System.out.print("User wanto delete >>>");
                    String idDelete = sc.nextLine();
                    bookService.deleteById(idDelete);
                    break;
                case 5:
//                    bookService.getAllByAuthor();
                    break;
            }
        }
    }


    public static int adminManager() throws IOException {
        while (true) {
            Menu.menuAdmin();
            System.out.print("Choose manger >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            switch (chooseMenu) {
                case 0:
                    break;
                case 1:
                    adminUser();
                    break;
                case 2:
                    adminBook();
                    break;
                case 3:
                    adminAuthor();
                    break;
                case 4:
                    adminOrder();
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            List<BookDTO> bookDTOS = bookService.getAll();
            System.out.printf(
                    " %-15s, %-15s\n",
                    "name", "quantity");
            for (BookDTO it : bookDTOS) {
                System.out.printf(
                        " %-15s, %-15d\n",
                        it.getName(), it.getQuantity());
            }
            Menu.menu();
            System.out.print("Your choose >>");
            int chooseMenu = FuntionUtil.inputOneNum();
            while (chooseMenu == 0) {
                System.out.println("Bye");
                System.exit(0);
            }



            //--------------------------------admin
//            if (chooseMenu == 1)
//                adminManager();
            switch (chooseMenu){
                case 0:
                    System.out.println("Bye");
                    System.exit(0);
                case 1:
                    UserDTO userDTO = userService.login();
                    if(userDTO == null)
                        System.out.println(" >> Login failed");
                    else
                    if(userDTO.getRoleId().strip().equalsIgnoreCase("admin"))
                        adminManager();
                    else if (userDTO.getRoleId().strip().equalsIgnoreCase("user")) {

                    }
                    break;
                case 2:

                    break;
            }
        }
    }
}