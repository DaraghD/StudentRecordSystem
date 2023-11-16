import CommandLineInterface.CommandLineInterface;

import java.io.FileNotFoundException;

public class main {

    //TODO: make every .java file under src its own folder/directory

    public static void main(String[] args) throws FileNotFoundException {
        CommandLineInterface cli = new CommandLineInterface();
        cli.init();
        cli.run();
        cli.shutdown();
    }


}
