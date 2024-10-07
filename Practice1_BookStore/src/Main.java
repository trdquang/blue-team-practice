import dto.UserDTO;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
        UserService userService = new UserService();
        List<UserDTO> userDTOS = userService.getAll();
        System.out.println("len = " + userDTOS.size());
        for(UserDTO it: userDTOS){
            System.out.println(it.getId() + ", " + it.getName());
        }
    }
}