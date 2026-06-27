package com.shoes.model;

public class OrderItem {

    private int itemId;
    private int orderId;
    private int shoeId;
    private int quantity;
    private double price;

    public OrderItem() {

    }

    public OrderItem(int itemId, int orderId, int shoeId,
            int quantity, double price) {

        this.itemId = itemId;
        this.orderId = orderId;
        this.shoeId = shoeId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}