package Grading;

import java.util.ArrayList;

public class Programme {
    // Modules are a part of the programme

    private ArrayList<Module> modules = new ArrayList<Module>();

    public void addModule(Module module){
        modules.add(module);
    }

}
