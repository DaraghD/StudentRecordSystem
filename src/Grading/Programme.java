package Grading;

import java.util.ArrayList;

public class Programme {
    // Modules are a part of the programme

    private ArrayList<Module> modules = new ArrayList<Module>();
    private String name;

    public void addModule(Module module){
        modules.add(module);
    }

    public String csvFormat(){
        String s = this.getName() + ",";
        for (Module module : modules) {
            s += module.csvFormat();
        }
        return s;
    }

    public String getName() {
        return name;
    }
}
