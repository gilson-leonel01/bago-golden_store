/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.controllers;

import bagogolden.enums.Category;
import bagogolden.models.SaleStatistics;
import bagogolden.models.User;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gilso
 */
public class StatisticsController {
    private SaleStatistics statistics;
    private UserController userController;
    private TransactionController transactionController;
    private ProductController productController;

    public StatisticsController(UserController userController, TransactionController transactionController, ProductController productController) {
        this.statistics = new SaleStatistics();
        this.userController = userController;
        this.transactionController = transactionController;
        this.productController = productController;
    }

    public double getAverageAge() { return statistics.calculateAverageAge(userController.getUsers()); }
    public double getAveragePrice() { return statistics.calculateAveragePrice(transactionController.getTransactions()); }
    public Category getMostPopularProduct() { return statistics.getMostPopularProduct(transactionController.getTransactions(), productController.getProducts()); }
    public Category getLeastPopularProduct() { return statistics.getLeastPopularProduct(transactionController.getTransactions(), productController.getProducts()); }
    public Map<String, Double> getGenderPercentage() { return statistics.getGenderPercentage(userController.getUsers()); }
    public List<User> getBirthdaysOnDate(LocalDate date) { return statistics.getBirthdaysOnDate(userController.getUsers(), date); }
}
