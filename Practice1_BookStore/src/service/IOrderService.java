package service;

import dto.OrderDTO;
import model.OrderItemModel;

import java.io.IOException;

public interface IOrderService extends BaseService<OrderDTO, OrderItemModel>{
    void groupByName() throws IOException;
}
