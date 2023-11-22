package CommandLineInterface;
import java.util.Scanner;
import Grading.Grade;
public class studentMenu {
    static Scanner input = new Scanner(System.in);

    public void run() {
        System.out.println("(Q)CA, (G)rades, (M)odules, (L)ogout");
        String choice = input.nextLine().toUpperCase();

        if (choice.equals("Q")) {
            choice = input.nextLine().toUpperCase();
            System.out.println("INPUT YEAR:");
            int year = Integer.parseInt(input.nextLine());
            System.out.println("INPUT SEMESTER:");
            int semester = Integer.parseInt(input.nextLine());
            System.out.println("INPUT MODULE:");
            String module = input.nextLine();

            int id = 22356363;

            double qca;
            qca = Grade.QCA( id, semester, module, year);
            System.out.println(qca);

        } else if (choice.equals("G")) {

        } else if (choice.equals("M")){

        } else if (choice.equals("L")){

        } else {
            System.out.print("Invalid Input");
        }



    }
}
    //Display QCA, Display QCA,

