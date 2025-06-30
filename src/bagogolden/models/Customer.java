/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bagogolden.models;

import java.time.LocalDate;

/**
 *
 * @author gilso
 */
public class Customer extends User {
    public Customer(String id, String name, int age, String gender, LocalDate birthDate) {
        super(id, name, age, gender, birthDate);
    }
    @Override
    public String getRole() { return "Cliente"; }
}
