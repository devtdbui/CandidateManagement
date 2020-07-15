package candidate;


import utils.Validate;
import entity.Experience;
import entity.Candidate;
import entity.Intern;
import entity.Fresher;
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
public class CandidateManagement {

    List<Candidate> listCandidates = new ArrayList<>();
    Validate validate = new Validate();

//    public int indexID(int id) {
//        for (int i = 0; i < listCandidates.size(); i++) {
//            if (listCandidates.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public void addCandidate(int type) {

        switch (type) {
            case 0:
                Experience E = new Experience();
                E.create(listCandidates);
                E.setType(type);
                listCandidates.add(E);
                break;
            case 1:
                Fresher f = new Fresher();
                f.create(listCandidates);
                f.setType(type);
                listCandidates.add(f);
                break;
            case 2:
                
                Intern I = new Intern();
                I.create(listCandidates);
                I.setType(type);
                listCandidates.add(I);
                break;

        }
    }
    
    public void search(){
        String inputSearch = validate.getString("Input Candidate name (First name or Last name):", "[a-zA-Z ]+");
        int type = validate.getInt("Input type of candidate: ", "Type [0-2]", 0, 2);
        
        for (Candidate C : listCandidates) {
            if(C.getType()==type){
                String fullName = C.getFirsName()+C.getLastName().toLowerCase();
                if(fullName.contains(inputSearch.toLowerCase())){
                    System.out.println(C);
                }
            }
        }
        
    }
    
    public void displayAll(){
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate C : listCandidates) {
            if(C instanceof Experience){
                System.out.println(C.getFirsName()+" "+C.getLastName());
            }
        }
        
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate C : listCandidates) {
            if(C instanceof Fresher){
                System.out.println(C.getFirsName()+" "+C.getLastName());
            }
        }
        
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate C : listCandidates) {
            if(C instanceof Intern){
                System.out.println(C.getFirsName()+" "+C.getLastName());
            }
        }

        //C2:
//        Collections.sort(listCandidates, new Comparator<Candidate>() {
//            @Override
//            public int compare(Candidate o1, Candidate o2) {
//               return o1.getType()-o2.getType();
//            }
//        });
//        System.out.println("===========EXPERIENCE CANDIDATE============");
//        int instance = 0;
//        for (Candidate C : listCandidates) {
//            if(C.getType()==1&&instance==0){
//                System.out.println("==========FRESHER CANDIDATE==============");
//                instance=1;
//            }
//            if(C.getType()==2&&instance==1){
//                System.out.println("==========INTERN CANDIDATE==============");
//                instance=2;
//            }
//            System.out.println(C.getFirsName()+" "+C.getLastName());
//        }
    }

}
