/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Cart;
import models.Categories;
import models.Items;
import models.OrderDetails;
import models.Orders;
import models.Products;
import models.Users;

/**
 *
 * @author thang05082001
 */
public class OrderDAO extends DBContext {

    public void insertOrder(Users user, Cart cart, String address) {
        try {
            String sql = "insert into Orders(UserName, OrderDate, CustomerName, Address, Email, Phone, TotalPrice) values(?,GETDATE(),?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUserName());
            stm.setString(2, user.getContact().getCustomerName());
            stm.setString(3, address);
            stm.setString(4, user.getContact().getEmail());
            stm.setString(5, user.getContact().getPhone());
            stm.setDouble(6, cart.getTotalMoneyD());
            stm.executeUpdate();
            String sql1 = "select top 1 OrderID from Orders order by OrderID desc";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            ResultSet rs1 = stm1.executeQuery();
            while (rs1.next()) {
                int oid = rs1.getInt(1);
                for (Items i : cart.getItems()) {
                    String sql2 = "insert into OrderDetail(OrderID, ProductID, Quantity, PricePerProduct) values(?,?,?,?)";
                    PreparedStatement stm2 = connection.prepareStatement(sql2);
                    stm2.setInt(1, oid);
                    stm2.setInt(2, i.getProduct().getProductID());
                    stm2.setInt(3, i.getQuantity());
                    stm2.setDouble(4, i.getPrice());
                    stm2.executeUpdate();
                }
            }
        } catch (Exception e) {
        }
    }

    public void removeQuantity(Cart cart) {
        try {
            String sql = "update Products\n"
                    + "  set Quantity = (select Quantity from Products where ProductID = ?) - ?\n"
                    + "  where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Items i : cart.getItems()) {
                stm.setInt(1, i.getProduct().getProductID());
                stm.setInt(2, i.getQuantity());
                stm.setInt(3, i.getProduct().getProductID());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<Orders> getOrdersFilter(String username, String sort, int page) {
        ArrayList<Orders> list = new ArrayList<>();
        try {
            String sql = "select * from Orders o where o.UserName = ?\n"
                    + (sort.equals("dateincrease")
                    ? "order by o.OrderDate desc OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY" : "order by o.OrderDate OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY");
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setInt(2, (page - 1) * 5);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(
                        rs.getInt("OrderID"),
                        rs.getString("UserName"),
                        rs.getString("OrderDate"),
                        rs.getString("CustomerName"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getDouble("TotalPrice"),
                        getOrderDetailByOrderId(rs.getInt("OrderID")));
                list.add(o);
            }
            System.out.println(list.size());
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<OrderDetails> getOrderDetailByOrderId(int oid) {
        ArrayList<OrderDetails> list = new ArrayList<>();
        try {
            String sql = "select *, od.Quantity as qty from OrderDetail od, Products p  where od.ProductID = p.ProductID and od.OrderID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, oid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Products p = new Products(rs.getInt("ProductID"), rs.getString("ProductName"), rs.getDouble("OrginalPrice"), rs.getString("Picture1"));
                OrderDetails od = new OrderDetails(rs.getInt("OrderDetailID"), rs.getInt("OrderID"), p, rs.getInt("qty"), rs.getDouble("PricePerProduct"));
                list.add(od);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int getNumberOrderByUserName(String username) {
        int number = 0;
        try {
            String sql = "select count(*) from Orders o where o.UserName = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return number;
    }
}
