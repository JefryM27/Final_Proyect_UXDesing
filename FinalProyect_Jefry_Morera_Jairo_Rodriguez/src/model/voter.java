
package model;

public class voter {

    private int id;
    private String name;
    private int idNumber;
    private int age;
    private String email;
    private int phoneNumber;

    public voter(int id, String name, int idNumber, int age, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public voter(String name, int idNumber, int age, String email, int phoneNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public voter() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }  
}
