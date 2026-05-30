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

@WebServlet("/items/edit")
public class ItemEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ItemDAO itemDAO = new ItemDAO();

        try {
            Item item = itemDAO.findById(id);

            request.setAttribute("item", item);

            request.getRequestDispatcher("/WEB-INF/views/item-edit.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}