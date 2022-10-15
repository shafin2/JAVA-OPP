
public class App{
    public static void main(String[] args) {
        Campus c1=new Campus("Lahore", new Employee("fr", "fcf", "ffv"));
        Campus c2=new Campus(c1);
        // Campus c2=(Campus)c1.clone();
        // Campus c2=new Campus(c1.getName(), c1.getDirector())
        // c1.campusMain();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        // System.out.printf(&c2);
    }
}