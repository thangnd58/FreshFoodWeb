/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllercart;

import dal.CategoryDAO;
import dal.WishListDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Categories;
import models.Products;
import models.Users;

/**
 *
 * @author thang05082001
 */
@WebServlet(name = "viewwishlist", urlPatterns = {"/viewwishlist"})
public class viewwishlist extends HttpServlet {

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
        ArrayList<Products> list = new ArrayList<>();
        WishListDAO wDAO = new WishListDAO();
        HttpSession session = request.getSession();
        Users user = null;
        try {
            user = (Users) session.getAttribute("user");
        } catch (Exception e) {
        }
        if(user!=null){
           list = wDAO.getList(user.getUserName());
        }
        System.out.println(list.size());
        request.setAttribute("wishList", list);
        loadCategory(request, response);
        getProductsInCart(request, response);
        request.getRequestDispatcher("wishlist.jsp").forward(request, response);
    }
    
    private void getProductsInCart(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Integer> products = new ArrayList<>();
        HttpSession session = request.getSession();
        int num = 0;
        if (session.getAttribute("numberProductInCart") != null) {
            num = (int) session.getAttribute("numberProductInCart");
        }
        request.setAttribute("numberCart", num);
    }
    
    private void loadCategory(HttpServletRequest request, HttpServletResponse response) {
        CategoryDAO catDAO = new CategoryDAO();
        ArrayList<Categories> categories = catDAO.getAllCategoryies();
        request.setAttribute("listCategory", categories);
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
        WishListDAO wDAO = new WishListDAO();
        int pid = 0;
        try {
            pid = Integer.parseInt(request.getParameter("pid"));
        } catch (Exception e) {
        }
        wDAO.deleteWishList(pid);
        response.sendRedirect("viewwishlist");
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
