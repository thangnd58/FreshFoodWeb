/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllercart;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.Items;
import models.Products;

/**
 *
 * @author thang05082001
 */
@WebServlet(name = "process", urlPatterns = {"/process"})
public class process extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        int num, id;
        try {
            num = Integer.parseInt(request.getParameter("num"));
            id = Integer.parseInt(request.getParameter("pid"));
            if ((num == -1) && (cart.getQuantityByID(id) <= 1)) {
                cart.removeItem(id);
            } else {
                ProductDAO pDAO = new ProductDAO();
                Products p = pDAO.getProductByID(id);
                double price = p.getOriginalD();
                Items i = new Items(p, num, price);
                cart.addItem(i);
            }
            ArrayList<Items> list = cart.getItems();
            session.setAttribute("numberProductInCart", list.size());
            session.setAttribute("cart", cart);
        } catch (Exception e) {
        }
        response.sendRedirect("viewcart");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        int id = Integer.parseInt(request.getParameter("pid"));
        cart.removeItem(id);
        ArrayList<Items> list = cart.getItems();
        session.setAttribute("numberProductInCart", list.size());
        session.setAttribute("cart", cart);
        response.sendRedirect("viewcart");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
