/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleruser;

import dal.CategoryDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Categories;
import models.Orders;
import models.Users;

/**
 *
 * @author thang05082001
 */
public class viewordered extends HttpServlet {

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
        loadCategory(request, response);
        getProductsInCart(request, response);
        request.getRequestDispatcher("viewordered.jsp").forward(request, response);
    }
    
    private void loadCategory(HttpServletRequest request, HttpServletResponse response) {
        CategoryDAO catDAO = new CategoryDAO();
        ArrayList<Categories> categories = catDAO.getAllCategoryies();
        request.setAttribute("listCategory", categories);
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
        OrderDAO oDAO = new OrderDAO();
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        ArrayList<Orders> list = new ArrayList<>();
        String link = "viewordered?";
        int cid = 0;
        String filter = "dateincrease";
        int pageNo = 1;
        int numberPage = 1;
        int rowNumber = 0;
        if(request.getParameter("filter")!=null){
            filter = request.getParameter("filter");
            link += "filter="+filter +"&";
        }
        if(request.getParameter("page")!=null){
            pageNo = Integer.parseInt(request.getParameter("page"));
        }
        list = oDAO.getOrdersFilter(user.getUserName(), filter, pageNo);
        rowNumber = oDAO.getNumberOrderByUserName(user.getUserName());
        numberPage = (rowNumber % 5 == 0 ? (rowNumber / 5) : ((rowNumber / 5) + 1));
        request.setAttribute("page", pageNo);
        request.setAttribute("num", numberPage);
        request.setAttribute("link", link);
        request.setAttribute("filter", filter);
        request.setAttribute("listOrder", list);
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
