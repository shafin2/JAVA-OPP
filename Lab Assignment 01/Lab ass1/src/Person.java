public class Person {
    private String firstName,lastName;
    Date dob;
    Person(String firstName,String lastName,Date dob){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setDOB(Date dob){
        this.dob=dob;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Date getDOB(){
        return dob;
    }
    public String toString(){
        return firstName+" "+lastName+" is born in "+dob;
    }
}
