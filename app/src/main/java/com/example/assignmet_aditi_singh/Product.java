package com.example.assignmet_aditi_singh;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String title;
    private String description;
    private List<String> images;
    private String category;
    private double price; // Changed to double
    private double discountPercentage; // Changed to double
    private double rating; // Changed to double
    private int stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private double weight; // Changed to double

    private Dimension dimension;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private String returnPolicy;
    private List<Review> reviews;
    private int minimumOrderQuantity;
    private Meta meta;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public Dimension getDimension() { return dimension; }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setDimension(Dimension dimension) { this.dimension = dimension; }
    public String getWarrantyInformation() { return warrantyInformation; }
    public void setWarrantyInformation(String warrantyInformation) { this.warrantyInformation = warrantyInformation; }
    public String getShippingInformation() { return shippingInformation; }
    public void setShippingInformation(String shippingInformation) { this.shippingInformation = shippingInformation; }
    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
    public String getReturnPolicy() { return returnPolicy; }
    public void setReturnPolicy(String returnPolicy) { this.returnPolicy = returnPolicy; }
    public int getMinimumOrderQuantity() { return minimumOrderQuantity; }
    public void setMinimumOrderQuantity(int minimumOrderQuantity) { this.minimumOrderQuantity = minimumOrderQuantity; }
    public Meta getMeta() { return meta; }
    public void setMeta(Meta meta) { this.meta = meta; }

    // Additional method to get the first image
    public String getFirstImage() {
        if (images != null && !images.isEmpty()) {
            return images.get(0);
        }
        return null;
    }
}
