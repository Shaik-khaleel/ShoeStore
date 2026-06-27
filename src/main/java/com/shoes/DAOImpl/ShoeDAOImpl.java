package com.shoes.DAOImpl;

import java.sql.*;
import java.util.*;

import com.shoes.dao.DBConnection;
import com.shoes.dao.ShoeDAO;
import com.shoes.model.Shoe;


public class ShoeDAOImpl implements ShoeDAO {

    Connection con = DBConnection.getConnection();

    public boolean addShoe(Shoe shoe) {

        try {

            String sql =
            "INSERT INTO shoes(shoe_name,brand,category,"
            + "description,price,sizes,image,stock,status)"
            + " VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, shoe.getShoeName());
            ps.setString(2, shoe.getBrand());
            ps.setString(3, shoe.getCategory());
            ps.setString(4, shoe.getDescription());
            ps.setDouble(5, shoe.getPrice());
            ps.setString(6, shoe.getSizes());
            ps.setString(7, shoe.getImage());
            ps.setInt(8, shoe.getStock());
            ps.setString(9, shoe.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateShoe(Shoe shoe) {

        try {

            String sql =
            "UPDATE shoes SET shoe_name=?,brand=?,"
            + "category=?,description=?,price=?,"
            + "sizes=?,image=?,stock=?,status=? "
            + "WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, shoe.getShoeName());
            ps.setString(2, shoe.getBrand());
            ps.setString(3, shoe.getCategory());
            ps.setString(4, shoe.getDescription());
            ps.setDouble(5, shoe.getPrice());
            ps.setString(6, shoe.getSizes());
            ps.setString(7, shoe.getImage());
            ps.setInt(8, shoe.getStock());
            ps.setString(9, shoe.getStatus());
            ps.setInt(10, shoe.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteShoe(int id) {

        try {

            String sql =
                    "DELETE FROM shoes WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Shoe getShoeById(int id) {

        Shoe shoe = null;

        try {

            String sql = "SELECT * FROM shoes WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                shoe = new Shoe();

                shoe.setId(rs.getInt("id"));
                shoe.setShoeName(rs.getString("shoe_name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setCategory(rs.getString("category"));
                shoe.setDescription(rs.getString("description"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setSizes(rs.getString("sizes"));
                shoe.setImage(rs.getString("image"));
                shoe.setStock(rs.getInt("stock"));
                shoe.setStatus(rs.getString("status"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return shoe;
    }

    public List<Shoe> getAllShoes() {

        List<Shoe> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM shoes";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Shoe shoe = new Shoe();

                shoe.setId(rs.getInt("id"));
                shoe.setShoeName(rs.getString("shoe_name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setCategory(rs.getString("category"));
                shoe.setDescription(rs.getString("description"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setSizes(rs.getString("sizes"));
                shoe.setImage(rs.getString("image"));
                shoe.setStock(rs.getInt("stock"));
                shoe.setStatus(rs.getString("status"));

                list.add(shoe);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    public List<Shoe> getShoesByCategory(String category) {

        List<Shoe> list = new ArrayList<>();

        try {

            String sql =
                    "SELECT * FROM shoes WHERE category=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Shoe shoe = new Shoe();

                shoe.setId(rs.getInt("id"));
                shoe.setShoeName(rs.getString("shoe_name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setCategory(rs.getString("category"));
                shoe.setDescription(rs.getString("description"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setSizes(rs.getString("sizes"));
                shoe.setImage(rs.getString("image"));
                shoe.setStock(rs.getInt("stock"));
                shoe.setStatus(rs.getString("status"));

                list.add(shoe);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Shoe> searchShoes(String keyword){

        List<Shoe> list =
                new ArrayList<>();

        try{

            String sql=
            "select * from shoes "
            + "where shoe_name like ?";

            PreparedStatement ps=
            con.prepareStatement(sql);

            ps.setString(1,
            "%" + keyword + "%");

            ResultSet rs=
            ps.executeQuery();

            while(rs.next()){

                Shoe shoe=
                        new Shoe();

                shoe.setId(
                rs.getInt("id"));

                shoe.setShoeName(
                rs.getString("shoe_name"));

                shoe.setBrand(
                rs.getString("brand"));

                shoe.setCategory(
                rs.getString("category"));

                shoe.setDescription(
                rs.getString("description"));

                shoe.setPrice(
                rs.getDouble("price"));

                shoe.setSizes(
                rs.getString("sizes"));

                shoe.setImage(
                rs.getString("image"));

                shoe.setStock(
                rs.getInt("stock"));

                shoe.setStatus(
                rs.getString("status"));

                list.add(shoe);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean reduceStock(int shoeId, int quantity) {

        try {

        	String sql =
        			"UPDATE shoes SET stock = stock - ? " +
        			"WHERE id = ? AND stock >= ?";
            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, shoeId);
            ps.setInt(3, quantity);
            
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}