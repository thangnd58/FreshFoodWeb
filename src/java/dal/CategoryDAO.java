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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categories;

/**
 *
 * @author thang05082001
 */
public class CategoryDAO extends DBContext{
    public ArrayList<Categories> getAllCategoryies() {
        ArrayList<Categories> list = new ArrayList<>();
        try {
            String sql = "select * from Categories";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categories s = new Categories(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));

                list.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public int getNumberProductByQuantity(int cid){
        try {
            String sql = "select count(*) from Products where CategoryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }
}
