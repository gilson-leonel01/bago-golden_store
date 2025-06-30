/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.controllers;

import bagogolden.models.Customer;
import bagogolden.models.Seller;
import bagogolden.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author gilso
 */
public class UserController {
    private List<User> users = new ArrayList<>();

    public String registerUser(String name, int age, String gender, LocalDate birthDate, String role) {
        String id = UUID.randomUUID().toString();
        User user = role.equalsIgnoreCase("Cliente") ?
                new Customer(id, name, age, gender, birthDate) :
                new Seller(id, name, age, gender, birthDate);
        users.add(user);
        return "Usuario : " + name + " (" + role + ") cadastrado com sucesso!";
    }

    public List<User> getUsers() { return users; }
}
