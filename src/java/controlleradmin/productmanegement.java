/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleradmin;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categories;
import models.Products;

/**
 *
 * @author thang05082001
 */
@WebServlet(name = "productmanegement", urlPatterns = {"/admin/productmanegement"})
public class productmanegement extends HttpServlet {

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
        CategoryDAO cDAO = new CategoryDAO();
        ArrayList<Categories> listC = cDAO.getAllCategoryies();
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("../editproduct.jsp").forward(request, response);
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
        ProductDAO proDAO = new ProductDAO();
        ArrayList<Products> products = new ArrayList<>();
        String link = "productmanegement?";
        int cid = 0;
        String filter = "default";
        int pageNo = 1;
        int numberPage = 1;
        int rowNumber = 0;
        if (request.getParameter("cid") != null) {
            cid = Integer.parseInt(request.getParameter("cid"));
            link += "cid=" + cid;
        }
        if (request.getParameter("filter") != null) {
            filter = request.getParameter("filter");
            link += "&filter=" + filter + "&";
        }
        if (request.getParameter("page") != null) {
            pageNo = Integer.parseInt(request.getParameter("page"));
        }
        products = proDAO.getProductFilter(cid, filter, pageNo,"","");
        rowNumber = proDAO.getCountByFilter(cid,"","");
        numberPage = (rowNumber % 12 == 0 ? (rowNumber / 12) : ((rowNumber / 12) + 1));
        request.setAttribute("page", pageNo);
        request.setAttribute("num", numberPage);
        request.setAttribute("link", link);
        request.setAttribute("filter", filter);
        request.setAttribute("cid", cid);
        request.setAttribute("listProduct", products);
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
        request.setCharacterEncoding("UTF-8");
        ProductDAO pDAO = new ProductDAO();
        int cid = Integer.parseInt(request.getParameter("category"));
        String name = request.getParameter("name");
        double price = 0;
        int quantity = 0;
        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch (Exception e) {
        }
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
        }
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String description = request.getParameter("description");
        pDAO.insertProduct(cid, name, price, quantity, image1, image2, description);
        String link = "productmanegement?";
        String filter = "default";
        int pageNo = 1;
        int numberPage = 1;
        int rowNumber = 0;
        if (request.getParameter("cid") != null) {
            cid = Integer.parseInt(request.getParameter("cid"));
            link += "cid=" + cid;
        }
        if (request.getParameter("filter") != null) {
            filter = request.getParameter("filter");
            link += "&filter=" + filter + "&";
        }
        if (request.getParameter("page") != null) {
            pageNo = Integer.parseInt(request.getParameter("page"));
        }
        response.sendRedirect(link);
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
