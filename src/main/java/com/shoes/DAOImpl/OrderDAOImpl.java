package com.shoes.DAOImpl;

import java.sql.*;

import java.util.*;

import com.shoes.dao.DBConnection;
import com.shoes.dao.OrderDAO;
import com.shoes.model.Order;
import com.shoes.model.Shoe;

public class OrderDAOImpl implements OrderDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public boolean placeOrder(Order order) {

        try {
        	String sql =
        			"INSERT INTO orders("
        			+ "user_id,"
        			+ "shoe_id,"
        			+ "shoe_name,"
        			+ "image,"
        			+ "size,"
        			+ "quantity,"
        			+ "price,"
        			+ "total,"
        			+ "customer_name,"
        			+ "phone,"
        			+ "address)"
        			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);
            ps.setInt(1, order.getUserId());

            ps.setInt(2, order.getShoeId());

            ps.setString(3, order.getShoeName());

            ps.setString(4, order.getImage());

            ps.setString(5, order.getSize());

            ps.setInt(6, order.getQuantity());

            ps.setDouble(7, order.getPrice());

            ps.setDouble(8, order.getTotal());

            ps.setString(9, order.getCustomerName());

            ps.setString(10, order.getPhone());

            ps.setString(11, order.getAddress());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Order> getOrdersByUser(int userId) {

        List<Order> list = new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM orders WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Order o = new Order();

                o.setId(rs.getInt("id"));
                o.setShoeName(
                        rs.getString("shoe_name"));

                o.setImage(
                        rs.getString("image"));

                o.setSize(
                        rs.getString("size"));

                o.setQuantity(
                        rs.getInt("quantity"));

                o.setPrice(
                        rs.getDouble("price"));

                o.setTotal(
                        rs.getDouble("total"));

                o.setAddress(
                        rs.getString("address"));

                o.setOrderStatus(
                        rs.getString("order_status"));

                list.add(o);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Order> getAllOrders() {

        List<Order> list =
                new ArrayList<>();

        try {

            String sql =
            "SELECT * FROM orders";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery();

            while(rs.next()) {

                Order order =
                        new Order();

                order.setId(
                rs.getInt("id"));

                order.setShoeName(
                rs.getString("shoe_name"));

                order.setImage(
                rs.getString("image"));

                order.setQuantity(
                rs.getInt("quantity"));

                order.setTotal(
                rs.getDouble("total"));

                order.setAddress(
                rs.getString("address"));

                order.setOrderStatus(
                rs.getString("order_status"));
                
                order.setCustomerName(
                		rs.getString("customer_name"));

                		order.setPhone(
                		rs.getString("phone"));

                list.add(order);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    @Override
    public boolean updateOrderStatus(
            int orderId,
            String status) {

        try {

            String sql =
            "UPDATE orders "
            + "SET order_status=? "
            + "WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setString(1,status);
            ps.setInt(2,orderId);

            return ps.executeUpdate()>0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM orders WHERE user_id=? ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setShoeId(rs.getInt("shoe_id"));

                order.setShoeName(rs.getString("shoe_name"));
                order.setImage(rs.getString("image"));
                order.setSize(rs.getString("size"));

                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getDouble("price"));
                order.setTotal(rs.getDouble("total"));

                // Customer Details
                order.setCustomerName(rs.getString("customer_name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));

                // Order Status
                order.setOrderStatus(rs.getString("order_status"));

                // Order Date
                order.setOrderDate(rs.getTimestamp("order_date"));

                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    

    public int getLastOrderId() {

        int orderId = 0;

        try {

            String sql = "SELECT MAX(id) FROM orders";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                orderId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }
    public Shoe getShoeById(int id) {

        Shoe shoe = null;

        try {

            String sql = "SELECT * FROM shoes WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                shoe = new Shoe();

                shoe.setId(rs.getInt("id"));
                shoe.setShoeName(rs.getString("shoe_name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setStock(rs.getInt("stock"));
                shoe.setImage(rs.getString("image"));
                shoe.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return shoe;
    }
    

    }
