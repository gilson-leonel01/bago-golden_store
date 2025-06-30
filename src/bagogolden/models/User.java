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
public abstract class User {
    private String id;
    private String name;
    private int age;
    private String gender;
    private LocalDate birthDate;

    public User(String id, String name, int age, String gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public abstract String getRole();
    
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}
