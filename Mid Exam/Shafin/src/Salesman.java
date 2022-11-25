public class Salesman extends Employee implements Payable,Comparable{
    public Salesman(String name,Date date,double totalSale, double commisionRate) {
        super(name,date);
        this.totalSale = totalSale;
        this.commisionRate = commisionRate;
        noOfSalesman++;
    }
    private double totalSale;
    private double commisionRate;
    static int noOfSalesman;
    public double getPaymentAmount(){
        double salary=getTotalSale()*getCommisionRate();
        return salary;
    }
    public double earning(){
        double salary=getTotalSale()*getCommisionRate();
        return salary;
    }
    public double getTotalSale() {
        return totalSale;
    }
    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
    public double getCommisionRate() {
        return commisionRate;
    }
    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }
    @Override
    public String toString() {
        return super.getName() + " " + super.getDateOfHiring() + " "+ getCommisionRate()+" "+getTotalSale();
    }

}
