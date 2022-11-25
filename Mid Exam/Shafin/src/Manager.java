public class Manager extends Employee implements Payable {
    private double fixedSalary;
    static int noOfManager;
    public Manager(String name, Date dateOfHiring, double fixedSalary) {
        super(name, dateOfHiring);
        this.fixedSalary = fixedSalary;
        noOfManager++;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getPaymentAmount() {
        return getFixedSalary();
    }

    @Override
    public double earning() {
        return getFixedSalary();
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getDateOfHiring() + " "+ getFixedSalary();
    }
}
