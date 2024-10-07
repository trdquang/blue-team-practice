package mapper;

import dto.OrderDTO;
import dto.UserDTO;
import entity.OrderItem;
import entity.User;
import model.OrderItemModel;
import model.UserModel;

public class OrderItemMapper {
    public static OrderDTO toDTO(OrderItem orderItem){
        return OrderDTO.builder()
                .id(orderItem.getId())
                .userId(orderItem.getUserId())
                .bookId(orderItem.getBookId())
                .sell(orderItem.getSell())
                .date(orderItem.getDate())
                .build();
    }

    public static OrderItem toEntity(OrderDTO orderDTO){
        return OrderItem.builder()
                .id(orderDTO.getId())
                .userId(orderDTO.getUserId())
                .bookId(orderDTO.getBookId())
                .sell(orderDTO.getSell())
                .date(orderDTO.getDate())
                .build();
    }

    public static OrderItem toEntity(OrderItemModel orderItemModel){
        return OrderItem.builder()
                .userId(orderItemModel.getUserId())
                .bookId(orderItemModel.getBookId())
                .sell(orderItemModel.getSell())
                .date(orderItemModel.getDate())
                .build();
    }
}
