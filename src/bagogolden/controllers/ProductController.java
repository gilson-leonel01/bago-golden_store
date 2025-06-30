/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.controllers;

import bagogolden.enums.Category;
import bagogolden.enums.Material;
import bagogolden.models.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author gilso
 */
public class ProductController {
    private List<Product> products = new ArrayList<>();

    public String addProduct(String category, String material, String description, double price, String sellerId) {
        try {
            Category cat = Category.valueOf(category);
            Material mat = Material.valueOf(material);
            String id = UUID.randomUUID().toString();
            products.add(new Product(id, cat, mat, description, price, sellerId));
            return "Produto adicionado: " + description;
        } catch (IllegalArgumentException e) {
            return "Categoria ou material invalido";
        }
    }

    public List<Product> getProducts() { return products; }
}
