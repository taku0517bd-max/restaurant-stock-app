package com.example.stock.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.stock.dao.ItemDAO;

@WebServlet("/items/delete")
public class ItemDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemDeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ItemDAO itemDAO = new ItemDAO();

        try {
            itemDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/items");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}