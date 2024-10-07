import dto.AuthorDTO;
import dto.OrderDTO;
import dto.UserDTO;
import model.UserModel;
import service.IOrderService;
import service.impl.AuthorService;
import service.impl.OrderService;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
        AuthorService au = new AuthorService();
        List<AuthorDTO> tmp = au.getAll();
        for(AuthorDTO it: tmp){
            System.out.println(it.getId() +", " + it.getName());
        }
    }

}