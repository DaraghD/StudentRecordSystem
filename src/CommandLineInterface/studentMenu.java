package CommandLineInterface;
import java.util.Scanner;
public class studentMenu {
    static Scanner input = new Scanner(System.in);

    public void run() {
        System.out.print("(Q)CA, (G)rades, (M)odules, (L)ogout");
        String choice = input.nextLine().toUpperCase();

        if (choice.equals("Q")) {

        } else if (choice.equals("G")) {

        } else if (choice.equals("M")){

        } else if (choice.equals("L")){
        } else {
            System.out.print("Invalid Input");
        }



    }
}
    //Display QCA, Display QCA,

