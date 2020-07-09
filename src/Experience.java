
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
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expInYear, String proSkill, int id, String firsName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(id, firsName, lastName, birthDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    @Override
    public void create(List<Candidate> list) {
        Validate v = new Validate();
        super.create(list);
        this.expInYear = v.getInt("Enter year of experience: ", "Year invalid", 1, 2020);
        this.proSkill = v.getString("Enter pro skill: ", "[a-zA-Z ]+");
        this.setType(0);
    }
    
    
    
}
