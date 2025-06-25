public class PartTimeEmployee extends AbstractEmployee {

    double hourlyRate;
    double hoursWorked;

    PartTimeEmployee(String name, String id, String department, double bSalary, double hourlyRate, double hoursWorked) {

        super(name, id, department, bSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {

        return bSalary + (hourlyRate * hoursWorked);
    }

    @Override
    public String getDetails() {

        return super.getDetails() + "Initial salary : " + bSalary + "\nHourly Rate    : " + hourlyRate + "\nHours worked   : " + hoursWorked + "\nTotal salary   : " + calculateSalary();
    }
}
