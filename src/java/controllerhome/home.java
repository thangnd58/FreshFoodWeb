
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerhome;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

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
        HttpSession session = request.getSession();
        Users user = null;
        try {
            user = (Users) session.getAttribute("user");
        } catch (Exception e) {
        }
        if(user!=null){
            session.setAttribute("logged", true);
        } else {
            session.setAttribute("logged", false);
        }
        loadProduct(request, response);
        getProductsInCart(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CategoryDAO catDAO = new CategoryDAO();
        ProductDAO proDAO = new ProductDAO();
        ArrayList<Categories> categories = catDAO.getAllCategoryies();
        ArrayList<Products> products = proDAO.getNewProducts();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listProduct", products);

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
