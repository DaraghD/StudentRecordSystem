import CommandLineInterface.CommandLineInterface;
import java.io.IOException;

public class StudentRecordSystem {
    //main method, where everything gets called
    public static void main(String[] args) throws IOException {
        CommandLineInterface cli = new CommandLineInterface();
        cli.init();
        cli.run();
        cli.shutdown();
    }
}
