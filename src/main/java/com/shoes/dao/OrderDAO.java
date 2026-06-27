package com.shoes.dao;

import java.util.List;
import com.shoes.model.Order;

public interface OrderDAO {

    boolean placeOrder(Order order);

    boolean updateOrderStatus(int orderId, String status);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getAllOrders();
}
