/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerhome;

import dal.SearchDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "searchByAjax", urlPatterns = {"/searchByAjax"})
public class searchByAjax extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        SearchDAO sDAO = new SearchDAO();
        ArrayList<Products> products = sDAO.searchByName(txtSearch);
        PrintWriter out = response.getWriter();
        for (Products p : products) {
            out.println("<div class=\"numberproduct col-md-3 col-sm-3 col-xs-12\">\n"
                    + "                                                <div class=\"product-item\" style=\"height: 140px\">\n"
                    + "                                                    <div class=\"product-image\">\n"
                    + "                                                        <a href=\"detail?pid=" + p.getProductID() + "\">\n"
                    + "                                                            <img class=\"img-responsive\" src=\"" + p.getImgURL1() + "\" alt=\"Product Image\">\n"
                    + "                                                        </a>\n"
                    + "                                                    </div>\n"
                    + "\n"
                    + "                                                    <div class=\"product-title\">\n"
                    + "                                                        <a href=\"detail?pid=" + p.getProductID() + "\">\n"
                    + "                                                            " + p.getProductName() + "\n"
                    + "                                                        </a>\n"
                    + "                                                    </div>\n"
                    + "\n"
                    + "                                                    <div class=\"product-rating\">\n"
                    + "                                                        <div class=\"star on\"></div>\n"
                    + "                                                        <div class=\"star on\"></div>\n"
                    + "                                                        <div class=\"star on \"></div>\n"
                    + "                                                        <div class=\"star on\"></div>\n"
                    + "                                                        <div class=\"star on\"></div>\n"
                    + "                                                    </div>\n"
                    + "\n"
                    + "                                                    <div class=\"product-price\">\n"
                    + "                                                        <span class=\"sale-price\">" + p.getOriginal() + " đ</span>\n"
                    + "                                                    </div>\n"
                    + "\n"
                    + "                                                    <div class=\"product-buttons\">\n"
                    + "                                                            <a class=\"add-to-cart\" href=\"addcart?cid=" + p.getCategory().getCategoryID() + "&pid="+p.getProductID()+"&local=home\">\n"
                    + "                                                                <i class=\"fa fa-shopping-basket\" aria-hidden=\"true\"></i>\n"
                    + "                                                            </a>\n"
                    + "\n"
                    + "                                                        <a class=\"add-wishlist\" href=\"#\">\n"
                    + "                                                            <i class=\"fa fa-heart\" aria-hidden=\"true\"></i>												\n"
                    + "                                                        </a>\n"
                    + "\n"
                    + "                                                        <a class=\"quickview\" href=\"detail?pid=" + p.getProductID() + "\">\n"
                    + "                                                            <i class=\"fa fa-eye\" aria-hidden=\"true\"></i>\n"
                    + "                                                        </a>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                            </div>");
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
