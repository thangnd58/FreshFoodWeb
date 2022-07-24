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
import models.Products;

/**
 *
 * @author thang05082001
 */
public class ProductDetailDAO extends DBContext {

    public Products getProductByProductID(int pid) {
        Products p = new Products();
        try {
            String sql = "select p.*, c.* from Products p, Categories c where p.CategoryID = c.CategoryID and ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categories cat = new Categories(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));
                p = new Products(
                        rs.getInt("ProductID"),
                        cat,
                        rs.getString("ProductName"),
                        rs.getFloat("OrginalPrice"),
                        rs.getString("Description"),
                        rs.getInt("Quantity"),
                        rs.getString("Picture1"),
                        rs.getString("Picture2")
                );
            }
        } catch (SQLException e) {
        }
        return p;
    }
    
    public ArrayList<Products> getRelatedProducts(int cid) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select top 20 c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                    + "where c.CategoryID = ? order by newid()";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categories cat = new Categories(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));
                Products p = new Products(
                        rs.getInt("ProductID"),
                        cat,
                        rs.getString("ProductName"),
                        rs.getFloat("OrginalPrice"),
                        rs.getString("Description"),
                        rs.getInt("Quantity"),
                        rs.getString("Picture1"),
                        rs.getString("Picture2")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
