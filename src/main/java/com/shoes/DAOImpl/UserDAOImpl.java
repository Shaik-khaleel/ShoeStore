package com.shoes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.shoes.dao.DBConnection;
import com.shoes.dao.UserDAO;
import com.shoes.model.User;


public class UserDAOImpl implements UserDAO {

    private Connection con = DBConnection.getConnection();

    public boolean registerUser(User user) {

        try {

            String sql =
            "INSERT INTO users(name,email,password,mobile,address) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());   // hashed password
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getAddress());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
    public User loginUser(String email, String password) {

        User user = null;

        try {

            String sql = "SELECT * FROM users WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String dbPassword = rs.getString("password");

                if (BCrypt.checkpw(password, dbPassword)) {

                    user = new User();

                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(dbPassword);
                    user.setMobile(rs.getString("mobile"));
                    user.setAddress(rs.getString("address"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }    
    @Override
    public User getUserById(int id) {

        User user = null;

        try {

            String sql =
                    "SELECT * FROM users WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean updateUser(User user) {

        try {

            String sql =
                    "UPDATE users SET "
                  + "name=?,email=?,password=?,mobile=?,address=? "
                  + "WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
   
}