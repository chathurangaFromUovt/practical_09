public abstract class Person implements Checkup {

    private final String id, name;
    private String info;

    Person(String id, String name){

        this.id = id;
        this.name = name;

    }

    public String getInfo() {
        this.info = String.format("""
                ID            : %s
                Name          : %s
                """, this.id, this.name);

        return this.info;
    }
}

