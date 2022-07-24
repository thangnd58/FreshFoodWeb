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
import models.Categories;
import models.Products;

/**
 *
 * @author thang05082001
 */
public class WishListDAO extends DBContext {

    public void addToWishList(String username, int productId) {
        try {
            String sql = "insert into WishList values(?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setInt(2, productId);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public ArrayList<Products> getList(String username) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select p.*,c.* from WishList w, Products p, Categories c where w.ProductID = p.ProductID and p.CategoryID = c.CategoryID and w.UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
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
        }
        return list;
    }

    public boolean checkProductInList(String username, int pid) {
        int productId = 0;
        try {
            String sql = "select * from WishList where UserName = ? and ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setInt(2, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                productId = rs.getInt("ProductID");
            }
            if (productId != 0) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public void deleteWishList(int pid) {
        try {
            String sql = "delete from WishList where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
}
