
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class Options {

    public Options() {
    }

    public Options(List<Candidate> listCandidates) {
        this.listCandidates = listCandidates;
    }
    List<Candidate> listCandidates;
    Validate validate = new Validate();

    public void addCandidate(int type) {

        switch (type) {
            case 0:
                Experience E = new Experience();
                E.create(listCandidates);
                listCandidates.add(E);
                break;
            case 1:
                Fresher f = new Fresher();
                f.create(listCandidates);
                listCandidates.add(f);
                break;
            case 2:
                Intern I = new Intern();
                I.create(listCandidates);
                listCandidates.add(I);
                break;
        }
    }

    public void search() {
        String inputSearch = validate.getString("Input Candidate name (First name or Last name):", "[a-zA-Z ]+");
        int type = validate.getInt("Input type of candidate: ", "Type [0-2]", 0, 2);

        for (Candidate C : listCandidates) {
            if (C.getType() == type) {
                String fullName = C.getFirsName().toLowerCase() + C.getLastName().toLowerCase();
                if (fullName.contains(inputSearch.toLowerCase())) {
                    System.out.println(C);
                }
            }
        }

    }

    public void displayAll() {
        System.out.println("List of candidate:");
        Collections.sort(listCandidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return o1.getType() - o2.getType();
            }
        });
        System.out.println("===========EXPERIENCE CANDIDATE============");
        int instance = 0;
        for (Candidate C : listCandidates) {
            if (C.getType() == 1 && instance == 0) {
                System.out.println("==========FRESHER CANDIDATE==============");
                instance = 1;
            }
            if (C.getType() == 2 && instance == 1) {
                System.out.println("==========INTERN CANDIDATE==============");
                instance = 2;
            }
            System.out.println(C.getFirsName() + " " + C.getLastName());
        }
    }

}
