package entity;


import utils.Validate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ThinkPro
 */
public class Candidate {

    protected int id;
    protected String firsName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int type;

    public Candidate() {
    }

    public Candidate(int id, String firsName, String lastName, int birthDate, String address, String phone, String email, int type) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return firsName + " " + lastName + " | " + birthDate + " | " + address
                + " | " + phone + " | " + email + " | " + type;
    }

    public int indexID(List<Candidate> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void create(List<Candidate> list) {
        int id;
        do {
            id = Validate.getInt("Enter ID: ", "Id is a positive integer", 1, Integer.MAX_VALUE);
            if (indexID(list,id) != -1) {
                System.out.println("Id is exist. Please enter another ID");
            }
        } while (indexID(list,id) != -1);
        this.id=id;
        this.firsName = Validate.getString("Enter First Name: ", "[a-zA-Z ]+");
        this.lastName = Validate.getString("Enter Last Name: ", "[a-zA-Z ]+");
        this.birthDate = Validate.getInt("Enter birth date: ", "BirthDate invalid", 1900, 2020);
        this.address = Validate.getString("Enter address: ", "[a-zA-Z ]+");
        this.phone = Validate.getString("Enter phone: ", "\\d{10,}");
        this.email = Validate.getString("Enter email: ", "^[a-zA-Z]\\w+@(\\w+\\.)+\\w+$");  //lehon_123313gquan@gmail.com.vn.bn.test

    }

}
