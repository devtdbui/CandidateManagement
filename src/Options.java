
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Options {

    List<Candidate> list;

    public Options() {
    }

    public Options(List<Candidate> list) {
        this.list = list;
    }

    public void display() {
        //ctrl + space
        Collections.sort(list, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return o1.getType() - o2.getType();
            }
        });
        System.out.println("===========EXPERIENCE CANDIDATE============");
        int i = 0;
        for (Candidate o : list) {
            if (o.getType() == 1 && i == 0) {
                System.out.println("==========FRESHER CANDIDATE==============");
                i++;
            }
            if (o.getType() == 2 && i == 1) {
                System.out.println("==========FRESHER CANDIDATE==============");
                i++;
            }
            System.out.println(o.getFirsName() + " " + o.getLastName());
        }
    }

    public void search(String searchName, int type) {
        boolean check = false;
        for (Candidate o : list) {
            String fullName = o.getFirsName().toLowerCase() + " " + o.getLastName().toLowerCase();
            if (fullName.contains(searchName.toLowerCase()) && o.getType() == type) {
                if (check == false) {
                    System.out.println("The candidates found: ");
                    check = true;
                }
                System.out.println(o);
            }
        }
        if (check == false) {
            System.out.println("not found");
        }

    }

    public void add(int type) {
        Validate v = new Validate();
        do{
            switch(type){
                case 0:
                    Experience e = new Experience();
                    e.create(list);
                    list.add(e);
                    break;
                case 1:
                    Fresher f = new Fresher();
                    f.create(list);
                    list.add(f);
                    break;
                case 2:
                    Intern i = new Intern();
                    i.create(list);
                    list.add(i);
                    break;
            }
            if(!v.checkYesNo()){
                display();
                break;
            }
        }while(true);
    }
   

}
