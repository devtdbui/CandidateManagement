
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alias
 */
public class Candidate {
    private int id;
    private String firsName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;

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
        return  firsName+" "+lastName+" | "+address+" | "
                +phone+" | "+email+" | "+type;
    }
    public boolean checkExist(List<Candidate> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return false;
            }
        }
        return true;
    }

    public void create(List<Candidate> list) {
        Validate v = new Validate();
        int id;
        do {
            id = v.getInt("Enter ID: ", "Id is a positive integer", 1, Integer.MAX_VALUE);
            if(checkExist(list, id)==true){
                break;
            }else{
                System.out.println("id is exist, please input again");
            }
        } while (true);
        this.id = id;
        this.firsName = v.getString("Enter First Name: ", "^[a-zA-Z ]+$");
        this.lastName = v.getString("Enter Last Name: ", "^[a-zA-Z ]+$");
        this.birthDate = v.getInt("Enter birth date: ", "BirthDate invalid", 1900, 2020);
        this.address = v.getString("Enter address: ", "^[a-zA-Z ]+$");
        this.phone = v.getString("Enter phone: ", "^[0-9]{10,}$");
        this.email = v.getString("Enter email: ", "^[a-zA-Z]\\w+@(\\w+\\.)+\\w+$");  //lehon_123313gquan@gmail.com.vn.bn.test

    }
    
}
