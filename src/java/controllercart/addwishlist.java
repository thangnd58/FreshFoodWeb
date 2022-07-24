/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllercart;

import dal.WishListDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

/**
 *
 * @author thang05082001
 */
@WebServlet(name = "addwishlist", urlPatterns = {"/addwishlist"})
public class addwishlist extends HttpServlet {

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
        WishListDAO wDAO = new WishListDAO();
        int pid = 0;
        HttpSession session = request.getSession();
        Users user = null;
        try {
            pid = Integer.parseInt(request.getParameter("pid"));
        } catch (Exception e) {
        }
        try {
            user = (Users) session.getAttribute("user");
        } catch (Exception e) {
        }
        if (user != null && wDAO.checkProductInList(user.getUserName(), pid) == false) {
            wDAO.addToWishList(user.getUserName(), pid);
        }
        int cid = 0;
        int page = 0;
        try {
            cid = Integer.parseInt(request.getParameter("cid"));

        } catch (Exception e) {
        }
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
        }
        String local = request.getParameter("local");
        String filter = request.getParameter("filter");
        String pricefrom = request.getParameter("pricefrom");
        String priceto = request.getParameter("priceto");
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
        processRequest(request, response);
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
