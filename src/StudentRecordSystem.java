import CommandLineInterface.CommandLineInterface;
import java.io.IOException;

/**
 * Main class for the Student Record System application.
 */
public class StudentRecordSystem {
    /**
     * The main method where the Student Record System is initialized, run, and shutdown.
     *
     * @param args The command-line arguments - not used for this program
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        CommandLineInterface cli = new CommandLineInterface();
        cli.init();
        cli.run();
        cli.shutdown();
    }
}
