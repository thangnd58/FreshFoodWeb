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
public class ProductDAO extends DBContext {

    public ArrayList<Products> getNewProducts() {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select top 12 c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                    + "order by newid()";
            PreparedStatement stm = connection.prepareStatement(sql);
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

    public ArrayList<Products> getNext12Products(int amount) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                    + "ORDER BY newid() OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, amount);
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

    public ArrayList<Products> getProductsByPage(int page) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                    + "ORDER BY p.DateImport desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (page - 1) * 12);
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

    public ArrayList<Products> getProductFilter(int category, String sort, int page, String pricefrom, String priceto) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select c.*,p.* from Products p, Categories c where p.CategoryID = c.CategoryID"
                    + ((category != 0) ? " and p.CategoryID = ?\n " : "\n")
                    + "and p.OrginalPrice between ? and ?\n"
                    + ((sort.equals("priceincrease"))
                    ? "order by p.OrginalPrice OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY" : ((sort.equals("pricedecrease"))
                    ? "order by p.OrginalPrice desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY" : ((sort.equals("nameincrease"))
                    ? "order by p.ProductName OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY" : ((sort.equals("namedecrease"))
                    ? "order by p.ProductName desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY" : "order by p.DateImport desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY"))));
            PreparedStatement stm = connection.prepareStatement(sql);
            if (category != 0) {
                stm.setInt(1, category);
                if(pricefrom.equals("")){
                    stm.setDouble(2, 0);
                } else {
                    stm.setDouble(2, Double.parseDouble(pricefrom));
                }
                if(priceto.equals("")){
                    stm.setDouble(3, Double.MAX_VALUE);
                } else {
                    stm.setDouble(3, Double.parseDouble(priceto));
                }
                stm.setInt(4, (page - 1) * 12);
            } else {
                if(pricefrom.equals("")){
                    stm.setDouble(1, 0);
                } else {
                    stm.setDouble(1, Double.parseDouble(pricefrom));
                }
                if(priceto.equals("")){
                    stm.setDouble(2, Double.MAX_VALUE);
                } else {
                    stm.setDouble(2, Double.parseDouble(priceto));
                }
                stm.setInt(3, (page - 1) * 12);
            }
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

    public int getCountByFilter(int cid, String pricefrom, String priceto) {
        int number = 0;
        try {
            String sql = "select count(*) from Products p, Categories c where p.CategoryID = c.CategoryID"
                    + " and p.OrginalPrice between ? and ?\n"
                    + ((cid != 0) ? " and p.CategoryID = ? " : "");
            PreparedStatement stm = connection.prepareStatement(sql);
            System.out.println(sql);
            if (cid != 0) {
                if(pricefrom.equals("")){
                    stm.setDouble(1, 0);
                } else {
                    stm.setDouble(1, Double.parseDouble(pricefrom));
                }
                if(priceto.equals("")){
                    stm.setDouble(2, Double.MAX_VALUE);
                } else {
                    stm.setDouble(2, Double.parseDouble(priceto));
                }
                stm.setInt(3, cid);
            } else {
                if(pricefrom.equals("")){
                    stm.setDouble(1, 0);
                } else {
                    stm.setDouble(1, Double.parseDouble(pricefrom));
                }
                if(priceto.equals("")){
                    stm.setDouble(2, Double.MAX_VALUE);
                } else {
                    stm.setDouble(2, Double.parseDouble(priceto));
                }
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return number;
    }

    public int getNumberProducts() {
        int number = 0;
        try {
            String sql = "select count(*) from Products p join Categories c on p.CategoryID = c.CategoryID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

    public ArrayList<Products> getProductsByCatID(int cid, int page) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID\n where c.CategoryID = ?\n"
                    + "ORDER BY p.DateImport desc OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, (page - 1) * 9);
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

    public int getNumberProductsByCatID(int cid) {
        int number = 0;
        try {
            String sql = "select count(*) from Products p join Categories c on p.CategoryID = c.CategoryID where c.CategoryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

    public Products getProductByID(int productID) {
        Products p = new Products();
        try {
            String sql = "select c.*,p.* from Products p join Categories c on p.CategoryID = c.CategoryID where p.ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productID);
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

    public void deleteProduct(int id) {
        try {
            String sql = "delete from Products where ProductID = ?\n"
                    + "delete from OrderDetail where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateProduct(int id, String name, double price, int quantity, String img1, String img2, String descrition) {
        try {
            String sql = "update Products set ProductName = ?, OrginalPrice = ?, Description = ?, Quantity = ?, Picture1 = ?, Picture2 = ? where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, name);
            stm.setDouble(2, price);
            stm.setNString(3, descrition);
            stm.setInt(4, quantity);
            stm.setString(5, img1);
            stm.setString(6, img2);
            stm.setInt(7, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void insertProduct(int cid, String name, double price, int quantity, String img1, String img2, String descrition) {
        try {
            String sql = "insert into Products values(?,?,?,?,?,?,?,GETDATE())";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setNString(2, name);
            stm.setDouble(3, price);
            stm.setNString(4, descrition);
            stm.setInt(5, quantity);
            stm.setString(6, img1);
            stm.setString(7, img2);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
