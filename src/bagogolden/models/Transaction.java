/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.models;

import bagogolden.enums.PaymentStatus;
import java.time.LocalDate;

/**
 *
 * @author gilso
 */
public class Transaction {
    private String id;
    private String productId;
    private String buyerId;
    private String sellerId;
    private double price;
    private LocalDate date;
    private PaymentStatus paymentStatus;

    public Transaction(String id, String productId, String buyerId, String sellerId, double price, LocalDate date) {
        this.id = id;
        this.productId = productId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
        this.date = date;
        this.paymentStatus = PaymentStatus.Pendente;
    }
    
    public String getId() { return id; }
    public String getProductId() { return productId; }
    public String getBuyerId() { return buyerId; }
    public String getSellerId() { return sellerId; }
    public double getPrice() { return price; }
    public LocalDate getDate() { return date; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    
    public void setId(String id) { this.id = id; }
    public void setProductId(String productId) { this.productId = productId; }
    public void setBuyerId(String buyerId) { this.buyerId = buyerId; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId; }
    public void setPrice(double price) { this.price = price; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    
    public void completePayment() { this.paymentStatus = PaymentStatus.Completo; }
}
