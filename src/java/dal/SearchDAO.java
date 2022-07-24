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
public class SearchDAO extends DBContext {

    public ArrayList<Products> searchByName(String txtSearch) {
        ArrayList<Products> list = new ArrayList<>();
        int temp = 0;
        try {
            temp = Integer.parseInt(txtSearch);
        } catch (NumberFormatException e) {
        }
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID where p.ProductName like ? or p.ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            stm.setInt(2, temp);
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

    public ArrayList<Products> searchByNamePage(String txtSearch, int page) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID where p.ProductName like ?\n"
                    + "ORDER BY p.DateImport desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            stm.setInt(2, (page - 1) * 12);
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

    public int getNumberProducts(String txtSearch) {
        int number = 0;
        try {
            String sql = "select count(*) from Products p join Categories c on p.CategoryID = c.CategoryID where p.ProductName like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

}
