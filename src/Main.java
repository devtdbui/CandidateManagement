
import java.util.ArrayList;
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
public class Main {

    public static void menu(){
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1.	Experience");
        System.out.println("2.	Fresher");
        System.out.println("3.	Internship");
        System.out.println("4.	Searching");
        System.out.println("5.	Exit");
    }
    public static void main(String[] args) {
        List<Candidate> list = new ArrayList<>();
        Options op = new Options(list);
        list.add(new Fresher(2, "Le", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 1, 2019, "Good", "FPT"));
        list.add(new Intern(3, "Le", "Minh Nghia", 2001,
                "Thanh Hoa", "123456789", "nghia@gmail.com", 2, "KTPM", 3, "FPT"));
        list.add(new Experience(1, "Le", "Hong Quan", 1999,
                "Thanh Hoa", "0866823499", "quanlhhe130736@fpt.edu.vn", 0, 10, "Dev"));
        list.add(new Experience(4, "Le", "Van Quan", 1999,
                "Thanh Hoa", "0866823499", "quanlhhe130736@fpt.edu.vn", 0, 10, "Dev"));
        op.displayAll();
        Validate validate = new Validate();
        while (true) {
            menu();
            int option = validate.getInt("Enter your option[1-5]: ", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    op.addCandidate(0);
                    validate.checkYesNo(op, 0);
                    break;
                case 2:
                    op.addCandidate(1);
                    validate.checkYesNo(op, 1);
                    break;
                case 3:
                    op.addCandidate(2);
                    validate.checkYesNo(op, 1);
                    break;
                case 4:
                    op.displayAll();
                    op.search();
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }

}
