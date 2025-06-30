/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.models;

import bagogolden.enums.Category;
import bagogolden.enums.Material;

/**
 *
 * @author gilso
 */
public class Product {
    private String id;
    private Category category;
    private Material material;
    private String description;
    private double price;
    private String sellerId;

    public Product(String id, Category category, Material material, String description, double price, String sellerId) {
        this.id = id;
        this.category = category;
        this.material = material;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;
    }

    public String getId() { return id; }
    public Category getCategory() { return category; }
    public Material getMaterial() { return material; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getSellerId() { return sellerId; }
    
    public void setId(String id) { this.id = id; }
    public void setCategory(Category category) { this.category = category; }
    public void setMaterial(Material material) { this.material = material; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId;}
}
