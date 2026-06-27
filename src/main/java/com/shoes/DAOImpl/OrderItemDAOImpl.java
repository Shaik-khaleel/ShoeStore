package com.shoes.DAOImpl;

import java.sql.*;
import java.util.*;

import com.shoes.dao.DBConnection;
import com.shoes.dao.OrderItemDAO;
import com.shoes.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addOrderItem(OrderItem item) {

        try {

            String sql =
            "INSERT INTO order_items(order_id, shoe_id, quantity, price) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getShoeId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getPrice());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM order_items WHERE order_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                OrderItem item = new OrderItem();

                item.setItemId(rs.getInt("item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setShoeId(rs.getInt("shoe_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPrice(rs.getDouble("price"));

                list.add(item);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}