public abstract class Person {

    private String name;
    private int id;
    private String password;

    public Person(String name, int id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    abstract void Register();


}
