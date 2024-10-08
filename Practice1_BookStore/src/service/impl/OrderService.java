package service.impl;

import dto.BookDTO;
import dto.OrderDTO;
import dto.UserDTO;
import entity.OrderItem;
import entity.User;
import mapper.OrderItemMapper;
import mapper.UserMapper;
import model.OrderItemModel;
import service.IOrderService;
import util.FilePath;
import util.FileUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderService implements IOrderService {
    @Override
    public List<OrderDTO> getAll() throws IOException {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        try {
//            System.out.println(User.size);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            List<String> res = FileUtil.readFileBuffer(FilePath.CART_FILE_PATH);
//----------------------
            UserService userService = new UserService();
            BookServiceImplement bookServiceImplement = new BookServiceImplement();

            List<UserDTO> userDTOS = userService.getAll();
            List<BookDTO> bookDTOS = bookServiceImplement.getAll();
//            System.out.println("len = " + res.size());
            for (int i = 0; i < res.size(); i++) {
                String[] obj = res.get(i).split(",");

                String id = obj[0].strip();
                String userId = obj[1].strip();
                String bookId = obj[2].strip();
                Integer sell = Integer.parseInt(obj[3].strip());
                Date date = formatter.parse(obj[4].strip());

                String userName = null;
                String bookName = null;

                if (userService.findById(userId) != null) {
                    userName = userService.findById(userId).getName();
                }

                if (bookServiceImplement.findById(bookId) != null)
                    bookName = bookServiceImplement.findById(bookId).getName();

                OrderDTO orderTmp = new OrderDTO(id, userId, bookId, sell, date, userName, bookName);
                orderDTOS.add(orderTmp);
            }
//            System.out.println("Da den day" + orderDTOS.size());
            return orderDTOS;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }


    @Override
    public void save(OrderItemModel orderItemModel) {
        try {
            OrderItem orderItem = OrderItemMapper.toEntity(orderItemModel);
            orderItem.setId("order" + OrderItem.getSize());
            OrderItem.setSize(OrderItem.getSize() + 1);
//            System.out.println("Truoc savwe");
            System.out.println("Test = " + orderItem.toString());
            FileUtil.writeFile(FilePath.CART_FILE_PATH, "\n" + orderItem.toString(), true);

        } catch (Exception e) {
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
        for (int i = 0; i < orderDTOS.size(); i++) {
            if (orderDTOS.get(i).getId().equalsIgnoreCase(id)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Id not found");
        } else {
            orderDTOS.remove(pos);
            System.out.println("đã xóa");
            String lineWrite = "";
            for (int i = 0; i < orderDTOS.size(); i++) {
                lineWrite += OrderItemMapper.toEntity(orderDTOS.get(i)).toString() + "\n";
            }
            FileUtil.writeFile(FilePath.CART_FILE_PATH, lineWrite, false);
        }
    }

    @Override
    public OrderDTO findById(String id) throws IOException {
        List<OrderDTO> orderDTOS = getAll();
        int pos = -1;
        for (int i = 0; i < orderDTOS.size(); i++) {
            if (orderDTOS.get(i).getId().equalsIgnoreCase(id)) {
                pos = i;
                return orderDTOS.get(i);
            }
        }
        return null;
    }


    @Override
    public void groupByName() throws IOException {
        List<OrderDTO> orderDTOS = getAll();
        Map<String, TreeMap<String, Integer>> ds = new TreeMap<>();
        for (OrderDTO it : orderDTOS) {
            // Kiểm tra xem tên người dùng đã có trong map chưa
            if (ds.get(it.getUserName()) == null) {
                ds.put(it.getUserName(), new TreeMap<>()); //
            }

            // Lấy TreeMap của người dùng hiện tại
            TreeMap<String, Integer> bookMap = ds.get(it.getUserName());

            //
//            String bookKey = it.getBookName(); //
            System.out.println("name = " + it.getBookName());
            bookMap.put(it.getBookName(), bookMap.getOrDefault(it.getBookName(), 0) + it.getSell());
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : ds.entrySet()) {
            String userName = entry.getKey(); // Lấy tên người dùng
            TreeMap<String, Integer> bookMap = entry.getValue(); // Lấy TreeMap chứa sách của người dùng

            System.out.println("User: " + userName); // In ra tên người dùng

            // Duyệt qua các cuốn sách của người dùng
            for (Map.Entry<String, Integer> bookEntry : bookMap.entrySet()) {
                String bookName = bookEntry.getKey(); // Tên cuốn sách
                int count = bookEntry.getValue(); // Số lượng cuốn sách

                System.out.println("    Book: " + bookName + ", Quantity: " + count); // In ra cuốn sách và số lượng
            }
        }
    }
}
