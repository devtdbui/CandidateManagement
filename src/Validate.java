

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ThinkPro
 */
public class Validate {

    Scanner sc = new Scanner(System.in);
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
                System.out.println(msg);
                value = sc.nextLine();
                if (value.matches(pattern)) {
                    break;
                }
            } catch (Exception ex) {
            }

        } while (true);
        return value;
    }

    public void checkYesNo(Options m, int type) {
        String c = getString("Do you want to continue (Y/N)?", "[yYNn]");
        while (true) {
            if (c.equalsIgnoreCase("y")) {
                m.addCandidate(type);
            } else {
                m.displayAll();
                break;
            }
        }

    }
}
