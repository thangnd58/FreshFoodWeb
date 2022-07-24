/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Contacts;
import models.Users;

/**
 *
 * @author thang05082001
 */
public class LoginDAO extends DBContext {

    public Users login(String userName, String password) {
        Users u = new Users();
        try {
            String sql = "select * from Contact c, Users u where c.ContactID = u.ContactID and u.UserName = ? and u.PassWord = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
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
