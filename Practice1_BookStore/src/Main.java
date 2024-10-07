import dto.OrderDTO;
import dto.UserDTO;
import entity.OrderItem;
import model.OrderItemModel;
import model.UserModel;
import service.impl.OrderService;
import service.impl.UserService;
import util.FileUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException{
        OrderService orderService = new OrderService();
        List<OrderDTO> or = orderService.getAll();
//        for(OrderDTO it: or){
//            System.out.println(it.getId() + "; " + it.getBookId() + "; " + it.getSell() + "; " + it.getUserId() + "; " + it.getDate());
//        }
//
//        orderService.save(new OrderItemModel("1", "2", 3, new Date()));

        orderService.deleteById("1");
    }

}