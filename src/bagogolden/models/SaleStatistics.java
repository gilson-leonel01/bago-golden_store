/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.models;

import bagogolden.enums.Category;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author gilso
 */
public class SaleStatistics {
    public double calculateAverageAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0.0);
    }

    public double calculateAveragePrice(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getPrice).average().orElse(0.0);
    }

    public Category getMostPopularProduct(List<Transaction> transactions, List<Product> products) {
        Map<Category, Long> categoryCounts = transactions.stream()
                .map(t -> products.stream().filter(p -> p.getId().equals(t.getProductId())).findFirst().orElse(null))
                .filter(p -> p != null)
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        return categoryCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Category getLeastPopularProduct(List<Transaction> transactions, List<Product> products) {
        Map<Category, Long> categoryCounts = transactions.stream()
                .map(t -> products.stream().filter(p -> p.getId().equals(t.getProductId())).findFirst().orElse(null))
                .filter(p -> p != null)
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        return categoryCounts.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<String, Double> getGenderPercentage(List<User> users) {
        long total = users.size();
        Map<String, Long> genderCounts = users.stream()
                .collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
        Map<String, Double> percentages = new HashMap<>();
        genderCounts.forEach((gender, count) -> percentages.put(gender, (count * 100.0) / total));
        return percentages;
    }

    public List<User> getBirthdaysOnDate(List<User> users, LocalDate date) {
        return users.stream()
                .filter(u -> u.getBirthDate().getDayOfMonth() == date.getDayOfMonth() &&
                        u.getBirthDate().getMonth() == date.getMonth())
                .collect(Collectors.toList());
    }
}
