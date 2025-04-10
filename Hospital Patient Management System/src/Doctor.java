public class Doctor extends Person {

    private final String specialization;

    Doctor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    public String getInfo() {
        
        return super.getInfo() + "Special for   : " + specialization;
    }
}
