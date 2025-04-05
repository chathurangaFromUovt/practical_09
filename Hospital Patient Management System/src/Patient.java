public class Patient extends Person{

    private  final int age;
    private final String symptoms;

    Patient(String id, String name, int age, String symptoms) {
        super(id, name);
        this.age = age;
        this.symptoms = symptoms;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Age           : " + age + "\nSymptoms      : " + symptoms;
    }
}
