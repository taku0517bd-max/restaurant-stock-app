package com.example.stock.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.stock.dao.ItemDAO;
import com.example.stock.model.Item;

@WebServlet("/items/update")
public class ItemUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemUpdateServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Item item = new Item();

        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setCategory(request.getParameter("category"));
        item.setUnit(request.getParameter("unit"));
        item.setStockQuantity(Integer.parseInt(request.getParameter("stockQuantity")));
        item.setReorderPoint(Integer.parseInt(request.getParameter("reorderPoint")));

        String purchasePrice = request.getParameter("purchasePrice");
        if (purchasePrice == null || purchasePrice.isEmpty()) {
            item.setPurchasePrice(0);
        } else {
            item.setPurchasePrice(Integer.parseInt(purchasePrice));
        }

        item.setMemo(request.getParameter("memo"));

        ItemDAO itemDAO = new ItemDAO();

        try {
            itemDAO.update(item);
            response.sendRedirect(request.getContextPath() + "/items");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}