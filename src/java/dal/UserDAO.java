/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Contacts;
import models.Users;

/**
 *
 * @author thang05082001
 */
public class UserDAO extends DBContext {

    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> list = new ArrayList<>();
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contacts c = new Contacts(
                        rs.getInt("ContactID"),
                        rs.getString("CustomerName"),
                        rs.getString("EmailContact"),
                        rs.getString("Phone"),
                        rs.getString("SocialNetwork"));
                Users u = new Users(
                        rs.getString("UserName"),
                        c,
                        rs.getString("PassWord"),
                        rs.getString("Email"),
                        rs.getBoolean("Role"));
                list.add(u);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public ArrayList<Users> getUsersByName(String txt) {
        ArrayList<Users> list = new ArrayList<>();
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID and (u.UserName like ? or c.CustomerName like ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, "%"+txt+"%");
            stm.setNString(2, "%"+txt+"%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contacts c = new Contacts(
                        rs.getInt("ContactID"),
                        rs.getString("CustomerName"),
                        rs.getString("EmailContact"),
                        rs.getString("Phone"),
                        rs.getString("SocialNetwork"));
                Users u = new Users(
                        rs.getString("UserName"),
                        c,
                        rs.getString("PassWord"),
                        rs.getString("Email"),
                        rs.getBoolean("Role"));
                list.add(u);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void updateUser(String username, String fullname, String phone, String email) {
        try {
            int contactId = 0;
            String sql = "select ContactID from Users where UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                contactId = rs.getInt(1);
            }
            String sql1 = "update Contact set CustomerName = ?, EmailContact = ?, Phone = ? where ContactID = ?\n"
                    + "update Users set Email = ? where UserName = ?";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setString(1, fullname);
            stm1.setString(2, email);
            stm1.setString(3, phone);
            stm1.setInt(4, contactId);
            stm1.setString(5, email);
            stm1.setString(6, username);
            stm1.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updatePassword(String newpass, Users u) {
        try {
            String sql = "update Users set PassWord = ? where UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, newpass);
            stm.setString(2, u.getUserName());
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Users checkOldPass(Users u, String oldpass) {
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID and u.UserName = ? and u.PassWord = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUserName());
            stm.setString(2, oldpass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contacts c = new Contacts(
                        rs.getInt("ContactID"),
                        rs.getString("CustomerName"),
                        rs.getString("EmailContact"),
                        rs.getString("Phone"),
                        rs.getString("SocialNetwork"));
                return new Users(
                        rs.getString("UserName"),
                        c,
                        rs.getString("PassWord"),
                        rs.getString("Email"),
                        rs.getBoolean("Role"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteUser(String username) {
        try {
            int contactId = 0;
            String sql = "select ContactID from Users where UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                contactId = rs.getInt("ContactID");
            }
//            System.out.println(contactId);
//            String sql2 = "  delete from OrderDetail where OrderID in (select OrderID from Orders where UserName = ?)\n"
//                    + "  delete from Orders where UserName = ?";
//            PreparedStatement stm2 = connection.prepareStatement(sql2);
//            stm2.setString(1, username);
//            stm2.setString(2, username);
//            stm2.executeUpdate();
            String sql1 = "delete from Users where UserName = ? and Role = 0\n"
                    + "delete from Contact where ContactID = ?";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            stm1.setInt(2, contactId);
            stm1.setString(1, username);
            stm1.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Users getUserByUserName(Users u) {
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID and u.UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUserName());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Contacts c = new Contacts(
                        rs.getInt("ContactID"),
                        rs.getString("CustomerName"),
                        rs.getString("EmailContact"),
                        rs.getString("Phone"),
                        rs.getString("SocialNetwork"));
                return new Users(
                        rs.getString("UserName"),
                        c,
                        rs.getString("PassWord"),
                        rs.getString("Email"),
                        rs.getBoolean("Role"));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
