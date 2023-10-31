/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class candidate {
    private int id;
    private String name;
    private int idNumber;
    private int age;
    private String politicParty;

    public candidate(int id, String name, int idNumber, int age, String politicParty) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.politicParty = politicParty;
    }

    public candidate(String name, int idNumber, int age, String politicParty) {
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.politicParty = politicParty;
    }

    public candidate() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPoliticParty() {
        return politicParty;
    }

    public void setPoliticParty(String politicParty) {
        this.politicParty = politicParty;
    }
    
    
}
