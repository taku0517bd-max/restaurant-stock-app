package com.example.stock.model;

public class Item {
    private int id;
    private String name;
    private String category;
    private String unit;
    private int stockQuantity;
    private int reorderPoint;
    private int purchasePrice;
    private String memo;

    public Item() {
    }

    public Item(int id, String name, String category, String unit,
                int stockQuantity, int reorderPoint, int purchasePrice, String memo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.stockQuantity = stockQuantity;
        this.reorderPoint = reorderPoint;
        this.purchasePrice = purchasePrice;
        this.memo = memo;
    }

    public boolean isReorderNeeded() {
        return stockQuantity <= reorderPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }


    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}