/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.views;

import bagogolden.controllers.ProductController;
import bagogolden.controllers.StatisticsController;
import bagogolden.controllers.TransactionController;
import bagogolden.controllers.UserController;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author gilso
 */
public class ConsoleView {
    private UserController userController;
    private ProductController productController;
    private TransactionController transactionController;
    private StatisticsController statisticsController;
    private Scanner scanner;

    public ConsoleView() {
        this.userController = new UserController();
        this.productController = new ProductController();
        this.transactionController = new TransactionController(productController);
        this.statisticsController = new StatisticsController(userController, transactionController, productController);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        OUTER:
        while (true) {
            System.out.println("\nBago Golden - Seja Bem-Vindo!");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Comprar Produto");
            System.out.println("4. Ver Estatisticas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Idade: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Genero (M/F): ");
                    String gender = scanner.nextLine();
                    
                    System.out.print("Data de Nascimento (ANO-MES-DIA): ");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                    
                    System.out.print("Funcao (Cliente/Vendedor): ");
                    String role = scanner.nextLine();
                    
                    System.out.println(userController.registerUser(name, age, gender, birthDate, role));
                }
                case 2 -> {
                    System.out.print("Categoria: (Colar/Pulseira/Anel/Pingente/Medalha/Brinco/Relógio): ");
                    String category = scanner.nextLine();
                    
                    System.out.print("Material (Prata/Ouro): ");
                    String material = scanner.nextLine();
                    
                    System.out.print("Descricao: ");
                    String description = scanner.nextLine();
                    
                    System.out.print("Preco: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("ID do Vendedor: ");
                    String sellerId = scanner.nextLine();
                    
                    System.out.println(productController.addProduct(category, material, description, price, sellerId));
                }
                case 3 -> {
                    System.out.println("Produtos disponiveis:");
                    productController.getProducts().forEach(p ->
                            System.out.println("ID: " + p.getId() + ", Categoria: " + p.getCategory() + ", Material: " + p.getMaterial() +
                                    ", Descricao: " + p.getDescription() + ", Preco: " + p.getPrice()));
                    
                    System.out.print("Insira o ID do Produto: ");
                    String productId = scanner.nextLine();
                    
                    System.out.print("Insira o ID do Comprador: ");
                    String buyerId = scanner.nextLine();
                    
                    System.out.println(transactionController.createTransaction(buyerId, productId));
                }
                case 4 -> {
                    System.out.println("Estatisticas:");
                    System.out.println("Media de Idade: " + statisticsController.getAverageAge());
                    System.out.println("Media de Preco: " + statisticsController.getAveragePrice());
                    System.out.println("Produto mais solicitado: " + statisticsController.getMostPopularProduct());
                    System.out.println("Produto menos solicitadot: " + statisticsController.getLeastPopularProduct());
                    System.out.println("Percentagem do Genero: " + statisticsController.getGenderPercentage());
                    
                    System.out.print("Insira a data para aniversários (ANO-MES-DIA): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    
                    statisticsController.getBirthdaysOnDate(date).forEach(u ->
                            System.out.println("Aniversário: " + u.getName() + " (" + u.getRole() + ")"));
                }
                case 5 -> {
                    break OUTER;
                }
                default -> {
                    System.out.println("Opcao invalida!");
                }
            }
        }
    }
}
