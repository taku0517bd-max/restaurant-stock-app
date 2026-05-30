package com.example.stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.stock.model.Item;
import com.example.stock.util.DBUtil;

public class ItemDAO {

    public List<Item> findAll() throws SQLException {
        List<Item> itemList = new ArrayList<>();

        String sql = "SELECT * FROM items ORDER BY id";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setUnit(rs.getString("unit"));
                item.setStockQuantity(rs.getInt("stock_quantity"));
                item.setReorderPoint(rs.getInt("reorder_point"));
                item.setPurchasePrice(rs.getInt("purchase_price"));
                item.setMemo(rs.getString("memo"));

                itemList.add(item);
            }
        }

        return itemList;
    }
    public void insert(Item item) throws SQLException {
        String sql = "INSERT INTO items "
                + "(name, category, unit, stock_quantity, reorder_point, purchase_price, memo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setString(3, item.getUnit());
            pstmt.setInt(4, item.getStockQuantity());
            pstmt.setInt(5, item.getReorderPoint());
            pstmt.setInt(6, item.getPurchasePrice());
            pstmt.setString(7, item.getMemo());

            pstmt.executeUpdate();
        }
    }
    public Item findById(int id) throws SQLException {
        String sql = "SELECT * FROM items WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Item item = new Item();

                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCategory(rs.getString("category"));
                    item.setUnit(rs.getString("unit"));
                    item.setStockQuantity(rs.getInt("stock_quantity"));
                    item.setReorderPoint(rs.getInt("reorder_point"));
                    item.setPurchasePrice(rs.getInt("purchase_price"));
                    item.setMemo(rs.getString("memo"));

                    return item;
                }
            }
        }

        return null;
    }
    public void update(Item item) throws SQLException {
        String sql = "UPDATE items SET "
                + "name = ?, "
                + "category = ?, "
                + "unit = ?, "
                + "stock_quantity = ?, "
                + "reorder_point = ?, "
                + "purchase_price = ?, "
                + "memo = ? "
                + "WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setString(3, item.getUnit());
            pstmt.setInt(4, item.getStockQuantity());
            pstmt.setInt(5, item.getReorderPoint());
            pstmt.setInt(6, item.getPurchasePrice());
            pstmt.setString(7, item.getMemo());
            pstmt.setInt(8, item.getId());

            pstmt.executeUpdate();
        }
    }
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM items WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
    public List<Item> searchByCategory(String category) throws SQLException {
        List<Item> itemList = new ArrayList<>();

        String sql = "SELECT * FROM items WHERE category LIKE ? ORDER BY id";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + category + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();

                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCategory(rs.getString("category"));
                    item.setUnit(rs.getString("unit"));
                    item.setStockQuantity(rs.getInt("stock_quantity"));
                    item.setReorderPoint(rs.getInt("reorder_point"));
                    item.setPurchasePrice(rs.getInt("purchase_price"));
                    item.setMemo(rs.getString("memo"));

                    itemList.add(item);
                }
            }
        }

        return itemList;
    }
    }