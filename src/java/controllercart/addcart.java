/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllercart;

import dal.ProductDAO;
import java.io.IOException;
import java.nio.charset.Charset;
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
@WebServlet(name = "addcart", urlPatterns = {"/addcart"})
public class addcart extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String pid = request.getParameter("pid");
        int num = 1, id;
        try {
            id = Integer.parseInt(pid);
            ProductDAO pDAO = new ProductDAO();
            Products p = pDAO.getProductByID(id);
            double price = p.getOriginalD();
            Items i = new Items(p, num, price);
            if (p.getQuantity() > 0) {
                cart.addItem(i);
            }
        } catch (Exception e) {
        }
        ArrayList<Items> list = cart.getItems();
        session.setAttribute("numberProductInCart", list.size());
        session.setAttribute("cart", cart);
        int cid = 0;
        int page = 0;
        try {
            cid = Integer.parseInt(request.getParameter("cid"));

        } catch (NumberFormatException e) {
        }
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }
        String filter = request.getParameter("filter");
        String pricefrom = request.getParameter("pricefrom");
        String priceto = request.getParameter("priceto");
        String local = request.getParameter("local");
        String txt = request.getParameter("txt");
        if (local.equals("products")) {
            response.sendRedirect("./" + local + "?cid=" + cid + "&filter=" + filter + "&pricefrom="+ pricefrom + "&priceto=" + priceto + "&page=" + page);
        }
        if (local.equals("home")) {
            response.sendRedirect("./" + local);
        }
        if (local.equals("detail")) {
            response.sendRedirect("./" + local + "?pid=" + pid);
        }
        if (local.contains("search")) {
            response.sendRedirect("./" + local + "?txt=" + txt + "&page=" + page);
        }
        if (local.equals("viewwishlist")) {
            response.sendRedirect("viewwishlist");
        }
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
        processRequest(request, response);
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
