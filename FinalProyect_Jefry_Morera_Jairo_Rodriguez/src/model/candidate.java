/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class candidate {

    private int id;
    private int idNumber;
    private String name;
    private int age;
    private String politicParty;
    private byte[] imageBytes;

    public candidate(int id, int idNumber, String name, int age, String politicParty, byte[] imageBytes) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.politicParty = politicParty;
        this.imageBytes = imageBytes;
    }

    public candidate(int idNumber, String name, int age, String politicParty, byte[] imageBytes) {
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.politicParty = politicParty;
        this.imageBytes = imageBytes;
    }

    public candidate(int id, String name, String politicParty, byte[] imageBytes) {
        this.id = id;
        this.name = name;
        this.politicParty = politicParty;
        this.imageBytes = imageBytes;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

}
