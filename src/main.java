import CommandLineInterface.CommandLineInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

public class main {

    //TODO: make every .java file under src its own folder/directory

    public static void main(String[] args) throws IOException {
        CommandLineInterface.init();
        CommandLineInterface.run();
        CommandLineInterface.shutdown();
    }


}
