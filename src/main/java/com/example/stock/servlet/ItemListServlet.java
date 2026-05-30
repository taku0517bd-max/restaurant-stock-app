package com.example.stock.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.stock.dao.ItemDAO;
import com.example.stock.model.Item;

@WebServlet("/items")
public class ItemListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemDAO itemDAO = new ItemDAO();

        try {
        	String category = request.getParameter("category");

        	List<Item> itemList;

        	if (category != null && !category.isEmpty()) {
        	    itemList = itemDAO.searchByCategory(category);
        	} else {
        	    itemList = itemDAO.findAll();
        	}

        	request.setAttribute("category", category);

            request.setAttribute("itemList", itemList);

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/WEB-INF/views/item-list.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}