public abstract class Employee implements Comparable{
    private Date dateOfHiring;
    private String name;
    static int noOfEmployee;
    public abstract double earning();
    public Employee(String name,Date dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
        this.name = name;
        noOfEmployee++;
    }
    public Date getDateOfHiring() {
        return dateOfHiring;
    }
    public void setDateOfHiring(Date dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee [dateOfHiring=" + dateOfHiring + ", name=" + name + "]";
    }
    @Override
    public int compareTo(Object o) {
        Employee e=(Employee)o;
        return this.getName().compareTo(e.getName());
    }
}
