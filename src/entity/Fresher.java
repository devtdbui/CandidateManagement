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
public class Fresher extends Candidate {

    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int id, String firsName, String lastName, int birthDate,
            String address, String phone, String email, int type,
            int graduationDate, String graduationRank, String education) {

        super(id, firsName, lastName, birthDate, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void create(List<Candidate> list) {
        super.create(list);
        this.graduationDate = Validate.getInt("Enter Graduation Time: ", "Graduation Time invalid", 1900, 2020);

        String rank;
        do {
            rank = Validate.getString("Enter Rank of Graduation: ", "[a-zA-Z]+");
        } while (!rank.equals("Excellence") && !rank.equals("Good") && !rank.equals("Fair") && !rank.equals("Poor"));
        this.graduationRank=rank;
        this.education = Validate.getString("Enter education: ", "[a-zA-Z ]+");
    }

}
