/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.controllers;

import bagogolden.models.Product;
import bagogolden.models.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author gilso
 */
public class TransactionController {
    private List<Transaction> transactions = new ArrayList<>();
    private ProductController productController;

    public TransactionController(ProductController productController) {
        this.productController = productController;
    }

    public String createTransaction(String buyerId, String productId) {
        Product product = productController.getProducts().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElse(null);
        if (product == null) return "Produto nao encontrado";
        String id = UUID.randomUUID().toString();
        Transaction transaction = new Transaction(id, productId, buyerId, product.getSellerId(), product.getPrice(), LocalDate.now());
        transaction.completePayment();
        transactions.add(transaction);
        return "Transacao completa com sucesso: ID do Produto " + productId;
    }

    public List<Transaction> getTransactions() { return transactions; }
}
