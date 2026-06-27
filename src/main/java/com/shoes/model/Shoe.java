package com.shoes.model;

public class Shoe {

    private int id;
    private String shoeName;
    private String brand;
    private String category;
    private String description;
    private double price;
    private String sizes;
    private String image;
    private int stock;
    private String status;

    public Shoe() {
    }

    public Shoe(int id, String shoeName, String brand,
                String category, String description,
                double price, String sizes,
                String image, int stock,
                String status) {

        this.id = id;
        this.shoeName = shoeName;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.price = price;
        this.sizes = sizes;
        this.image = image;
        this.stock = stock;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}