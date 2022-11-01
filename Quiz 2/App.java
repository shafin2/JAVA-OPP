class  A
{
    int a = 5;
    A(int a){
        System.out.println("Constructor of A");
    }
    {
        a++;
    }
    public int getA() {
        return a++;
    }
}

class B extends A{
    B(){
        super(2);
        System.out.println("Non Paramerterized Constructor of B");
    }
    B(int a){
        super(2);
        System.out.println("Paramerterized Constructor of B");
    }
}

class C extends B{
    int a = 2;
    C(){
    }
    C(int c){
        this();
    }
    static{
        System.out.println("Static Block of C");
    }
    {
        System.out.println("Non Static Block of C");
        a++;
    }

    @Override
    public int getA() {
        return ++a+super.a;
    }
}

class App {
    public static void main(String[] args) {
        A obj = new C(10);
        System.out.println("The value in a of C: " + obj.getA());
    }
}

