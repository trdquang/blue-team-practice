package service.impl;

import dto.OrderDTO;
import dto.UserDTO;
import entity.OrderItem;
import entity.User;
import mapper.OrderItemMapper;
import mapper.UserMapper;
import model.OrderItemModel;
import service.IOrrderService;
import util.FileUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService implements IOrrderService {
    @Override
    public List<OrderDTO> getAll() throws IOException {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        try {
//            System.out.println(User.size);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            List<String> res = FileUtil.readFileBuffer("src/util/cart.txt");
            System.out.println("len = " + res.size());
            for(int i = 0; i < res.size(); i++){
                String[] obj = res.get(i).split(",");

                String id = obj[0];
                String userId = obj[1];
                String bookId = obj[2];
                Integer sell = Integer.parseInt(obj[3].strip());
                Date date = formatter.parse(obj[4].strip());

                OrderDTO orderTmp = new OrderDTO(id, userId, bookId, sell, date);
                orderDTOS.add(orderTmp);
            }
            System.out.println("Da den day" + orderDTOS.size());
            return orderDTOS;

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }



    @Override
    public void save(OrderItemModel orderItemModel) {
        try{
            OrderItem orderItem = OrderItemMapper.toEntity(orderItemModel);
            orderItem.setId("order" + OrderItem.getSize());
            OrderItem.setSize(OrderItem.getSize() + 1);
            System.out.println("Truoc savwe");
            System.out.println("Test = " + orderItem.toString());
            FileUtil.writeFile("src/util/cart.txt", "\n" + orderItem.toString(), true);

        }catch (Exception e){
            System.out.println("Err: " + e);
        }
    }

    @Override
    public void edit(OrderDTO e) throws IOException {

    }

    @Override
    public void deleteById(String id) throws IOException {
        List<OrderDTO> orderDTOS = getAll();

        int pos = -1;
        for(int i = 0; i < orderDTOS.size(); i++){
            if(orderDTOS.get(i).getId().equalsIgnoreCase(id)){
                pos = i;
                break;
            }
        }

        if(pos == -1){
            System.out.println("Không có id này");
        }else{
            orderDTOS.remove(pos);
            System.out.println("đã xóa");
            String lineWrite = "";
            for(int i = 0; i < orderDTOS.size(); i++){
                lineWrite +=  OrderItemMapper.toEntity(orderDTOS.get(i)).toString() + "\n";
            }
            FileUtil.writeFile("src/util/cart.txt", lineWrite , false);
        }
    }

    @Override
    public OrderDTO findById(String id) throws IOException {
        List<OrderDTO> orderDTOS = getAll();
        int pos = -1;
        for(int i = 0; i < orderDTOS.size(); i++){
            if(orderDTOS.get(i).getId().equalsIgnoreCase(id)){
                pos = i;
                return orderDTOS.get(i);
            }
        }
        return null;
    }
}
