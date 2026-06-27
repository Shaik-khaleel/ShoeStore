package com.shoes.dao;

import java.util.List;

import com.shoes.model.OrderItem;

public interface OrderItemDAO {

    boolean addOrderItem(OrderItem item);

    List<OrderItem> getOrderItemsByOrderId(int orderId);

}