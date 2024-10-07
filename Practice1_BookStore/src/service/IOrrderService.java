package service;

import dto.OrderDTO;
import mapper.OrderItemMapper;
import model.OrderItemModel;

public interface IOrrderService extends BaseService<OrderDTO, OrderItemModel>{
    void save(OrderItemModel orderItemModel);
}
