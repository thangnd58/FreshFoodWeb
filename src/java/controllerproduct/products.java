/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerproduct;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "products", urlPatterns = {"/products"})
public class products extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }

    private void loadCategory(HttpServletRequest request, HttpServletResponse response) {
        CategoryDAO catDAO = new CategoryDAO();
        Map<Categories, Integer> map = new HashMap<>();
        ArrayList<Categories> categories = catDAO.getAllCategoryies();
        for (Categories c : categories) {
            map.put(c, catDAO.getNumberProductByQuantity(c.getCategoryID()));
        }
        int count = 0;
        for (Map.Entry<Categories, Integer> entry : map.entrySet()) {
            Categories key = entry.getKey();
            Integer value = entry.getValue();
            count += value;
        }
        request.setAttribute("totalProduct", count);
        request.setAttribute("listCNum", map);
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
        HttpSession session = request.getSession();
        Users user = null;
        try {
            user = (Users) session.getAttribute("user");
        } catch (Exception e) {
        }
        if (user != null) {
            session.setAttribute("logged", true);
        } else {
            session.setAttribute("logged", false);
        }
        loadCategory(request, response);
        ProductDAO proDAO = new ProductDAO();
        ArrayList<Products> products = null;
        String link = "products?";
        int cid = 0;
        String filter = "default";
        String pricefrom = "";
        String priceto = "";
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
        if (request.getParameter("pricefrom") != null) {
            pricefrom = request.getParameter("pricefrom");
            link += "&pricefrom=" + pricefrom;
        }
        if (request.getParameter("priceto") != null) {
            priceto = request.getParameter("priceto");
            link += "&priceto=" + priceto + "&";
        }
        if (request.getParameter("page") != null) {
            pageNo = Integer.parseInt(request.getParameter("page"));
        }
        products = proDAO.getProductFilter(cid, filter, pageNo, pricefrom, priceto);
        rowNumber = proDAO.getCountByFilter(cid, pricefrom, priceto);
        numberPage = (rowNumber % 12 == 0 ? (rowNumber / 12) : ((rowNumber / 12) + 1));
        request.setAttribute("page", pageNo);
        request.setAttribute("num", numberPage);
        request.setAttribute("link", link);
        request.setAttribute("filter", filter);
        request.setAttribute("cid", cid);
        request.setAttribute("pricefrom", pricefrom);
        request.setAttribute("priceto", priceto);
        request.setAttribute("mess", "Danh sách sản phẩm");
        request.setAttribute("listProduct", products);
        getProductsInCart(request, response);
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
