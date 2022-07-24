/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Contacts;
import models.Users;

/**
 *
 * @author thang05082001
 */
public class RegisterDAO extends DBContext {

    public void insertUser(String userName, String password, String customerName, String email, String phoneNumber) {
        try {
            int contactID = 0;
            String sql = "insert into Contact(CustomerName, EmailContact, Phone) values (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, customerName);
            stm.setString(2, email);
            stm.setString(3, phoneNumber);
            stm.executeUpdate();
            String sql1 = "select top 1 ContactID from Contact order by ContactID desc";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            ResultSet rs1 = stm1.executeQuery();
            while (rs1.next()) {
                contactID = rs1.getInt(1);
            }
            String sql2 = "insert into Users(UserName, ContactID, PassWord, Email, Role) values (?,?,?,?,0)";
            PreparedStatement stm2 = connection.prepareStatement(sql2);
            stm2.setString(1, userName);
            stm2.setInt(2, contactID);
            stm2.setString(3, password);
            stm2.setString(4, email);
            stm2.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Users checkValidUserName(String userName) {
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID and u.UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
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
        } catch (SQLException e) {
        }
        return null;
    }
}
