package CommandLineInterface;
import java.util.Scanner;
public class studentMenu {
    static Scanner input = new Scanner(System.in);

    public void run() {
        System.out.print("(Q)CA, (G)rades");
        String choice = input.nextLine().toUpperCase();

        if (choice.equals("Q")) {

        } else if (choice.equals("G")) {

        } else {
            System.out.print("Invalid Input");
        }


    }
}
    //Display QCA, Display QCA,

