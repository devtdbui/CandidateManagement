
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alias
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1.	Experience");
        System.out.println("2.	Fresher");
        System.out.println("3.	Internship");
        System.out.println("4.	Searching");
        System.out.println("5.	Exit");
    }

    public int getInt(String msg, String err, int min, int max) {
        int a = 0;
        boolean check;
        do {
            check = true;
            try {
                System.out.print(msg);
                a = Integer.parseInt(sc.nextLine());
                if (a < min || a > max) {
                    System.out.println(err);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(err);
                check = false;
            }
        } while (check == false);
        return a;
    }

    public String getString(String msg, String pattern) {
        String value;
        do {
            try {
                System.out.print(msg);
                value = sc.nextLine();
                Pattern p = Pattern.compile(pattern);
                if (p.matcher(value).find()) {
                    break;
                }
            } catch (Exception ex) {
            }

        } while (true);
        return value;
    }

    public boolean checkYesNo() {
        String c = getString("Do you want to continue (Y/N)?", "[yYNn]");
        while (true) {
            if (c.equalsIgnoreCase("y")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
