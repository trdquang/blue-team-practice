import dto.UserDTO;
import model.UserModel;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
        UserService userService = new UserService();
//        userService.save(new UserModel(  "abc", "2", "3"));
        UserDTO u = userService.findById("user11");
        userService.edit(u);
    }

}