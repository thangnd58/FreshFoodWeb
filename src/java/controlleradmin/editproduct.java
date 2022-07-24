/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleradmin;

import dal.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Products;

/**
 *
 * @author thang05082001
 */
@WebServlet(name = "editproduct", urlPatterns = {"/admin/editproduct"})
public class editproduct extends HttpServlet {

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
        ProductDAO pDAO = new ProductDAO();
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }
        int pid = 0;
        int cid = 0;
        String filter = request.getParameter("filter");
        try {
            pid = Integer.parseInt(request.getParameter("pid"));
        } catch (NumberFormatException e) {
        }
        try {
            cid = Integer.parseInt(request.getParameter("cid"));
        } catch (NumberFormatException e) {
        }
        String local = request.getParameter("local");
        pDAO.deleteProduct(pid);
        response.sendRedirect("/FreshFoodWeb/admin/productmanegement?page=" + page + "&cid=" + cid + "&filter=" + filter);
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
        request.setCharacterEncoding("UTF-8");
        ProductDAO pDAO = new ProductDAO();
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }
        int id = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");
        double price = 0;
        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch (NumberFormatException e) {
        }
        int cid = 0;
        String filter = request.getParameter("filter");
        try {
            cid = Integer.parseInt(request.getParameter("cid"));
        } catch (NumberFormatException e) {
        }
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String description = request.getParameter("description");
        pDAO.updateProduct(id, name, price, quantity, image1, image2, description);
        String local = request.getParameter("local");
        response.sendRedirect("/FreshFoodWeb/admin/productmanegement?page=" + page + "&cid=" + cid + "&filter=" + filter);
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
