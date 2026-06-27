package com.shoes.DAOImpl;

import java.sql.*;
import java.util.*;

import com.shoes.dao.CartDAO;
import com.shoes.dao.DBConnection;
import com.shoes.model.Cart;


public class CartDAOImpl implements CartDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public boolean addToCart(Cart cart) {

        try {

            String sql =
            "insert into cart(user_id,shoe_id,quantity,size)"
            + " values(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getShoeId());
            ps.setInt(3, cart.getQuantity());
            ps.setString(4, cart.getSize());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Cart> getCartItems(int userId) {

        List<Cart> list = new ArrayList<>();

        try {

            String sql =
            "SELECT c.*,s.shoe_name,s.price,s.image "
            + "FROM cart c "
            + "JOIN shoes s ON c.shoe_id=s.id "
            + "WHERE c.user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Cart cart = new Cart();

                cart.setId(rs.getInt("id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setShoeId(rs.getInt("shoe_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setSize(rs.getString("size"));

                cart.setShoeName(
                        rs.getString("shoe_name"));

                cart.setPrice(
                        rs.getDouble("price"));

                cart.setImage(
                        rs.getString("image"));

                list.add(cart);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean removeCartItem(int cartId) {

        try {

            String sql =
                    "delete from cart where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, cartId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean clearCart(int userId){

        try{

            String sql =
            "delete from cart where user_id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1,userId);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
    
    @Override
    public boolean updateQuantity(int cartId, int quantity) {

        try {

            String sql =
            "UPDATE cart SET quantity=? WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, cartId);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    

}