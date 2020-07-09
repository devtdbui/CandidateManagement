
import java.util.ArrayList;
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
public class CandidateManager {

    public static void main(String[] args) {
        List<Candidate> list = new ArrayList<>();
        list.add(new Experience(2, "Good", 3, "Trinh", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 0));
        list.add(new Experience(2, "Good", 2, "Nguyen", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 0));
        list.add(new Fresher(2, "KTPM", "FPT", 4, "Le", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 1));
        list.add(new Fresher(2, "KTPM", "FPT", 1, "Le", "Van A", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 1));
        list.add(new Intern("DEV", 3, "FPT", 5, "Le", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 2));
        list.add(new Intern("DEV", 3, "FPT", 6, "Le", "Nhat Minh", 2001,
                "Thanh Hoa", "0385739160", "minhln@gmail.com", 2));
        Validate v = new Validate();
        Options op = new Options(list);
        op.display();
        while (true) {
            v.menu();
            int choice = v.getInt("Enter your option[1-5]: ", "Option[1-5]", 1, 5);
            switch (choice) {
                case 1:
                    op.add(0);
                    break;
                case 2:
                    op.add(1);
                    break;
                case 3:
                    op.add(2);
                    break;
                case 4:
                    String inputSearch = v.getString("Input Candidate name (First name or Last name):", "[a-zA-Z ]+");
                    int type = v.getInt("Input type of candidate: ", "Type [0-2]", 0, 2);
                    op.search(inputSearch, type);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
