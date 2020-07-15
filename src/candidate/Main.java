package candidate;


import utils.Validate;
import entity.Experience;
import entity.Intern;
import entity.Fresher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThinkPro
 */
public class Main {

    public static void main(String[] args) {
        CandidateManagement manager = new CandidateManagement();
        
        
        Validate validate = new Validate();
        boolean loop = true;
        while (loop) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1.	Experience\n"
                    + "2.	Fresher\n"
                    + "3.	Internship\n"
                    + "4.	Searching\n"
                    + "5.	Exit");
            int option = validate.getInt("Enter your option[1-5]: ", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    manager.addCandidate(0);
                    validate.checkYesNo(manager,0);
                    break;
                case 2:
                    manager.addCandidate(1);
                    validate.checkYesNo(manager,1);
                    break;
                case 3:
                    manager.addCandidate(2);
                    validate.checkYesNo(manager,1);
                    break;
                case 4:
                    manager.displayAll();
                    manager.search();
                    break;
                case 5:
                    loop = false;
                    break;

            }
        }
    }

}
