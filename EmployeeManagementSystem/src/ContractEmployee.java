public class ContractEmployee extends AbstractEmployee {

    double contractAmount;
    int contractDuration;

    ContractEmployee(String name, String id, String department, double bSalary, double contractAmount, double contractDuration) {

        super(name, id, department, bSalary);
        this.contractAmount = contractAmount;

        //validate into Integer because of months
        //assume no half of month contracts
        this.contractDuration = (int)contractDuration;
    }

    @Override
    public double calculateSalary() {
        return bSalary + (contractAmount / contractDuration);
    }

    @Override
    public String getDetails() {

        return super.getDetails() + "Initial salary : " + bSalary + "\nAmount         : " + contractAmount + "\nDuration       : " + contractDuration + "\nTotal salary   : " + calculateSalary();
    }
}
