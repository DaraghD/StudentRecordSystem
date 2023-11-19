import CommandLineInterface.CommandLineInterface;
import java.io.IOException;

public class StudentRecordSystem {
    //main method, where everything gets called
    public static void main(String[] args) throws IOException {
        CommandLineInterface.init();
        CommandLineInterface.run();
        CommandLineInterface.shutdown();
    }
}
