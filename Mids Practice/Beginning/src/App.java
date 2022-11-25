class A {
    int a = 5;//6
    
    A(int a) {
        System.out.println("Constructor of A");
    }
    {
        a++;
    }

    public int getA() {
        return a++;
    }
}

class B extends A {
    B() {
        super(2);
        System.out.println("Non Paramerterized Constructor of B");
    }
    B(int a) {
        super(2);
        System.out.println("Paramerterized Constructor of B");
    }
}

class C extends B {
    int a = 2;//3

    C() {
        a+=super.a++;
    }

    C(int c) {
        this();
    }

    static {
        System.out.println("Static Block of C");
    }
    {
        a++;
    }
    @Override
    public int getA() {
        return a++ + super.a;//4+6=10
    }
}

class App {
    public static void main(String[] args) {
        A obj = new C(10);
        A obj2 = new C(130);
        // System.out.println("2nd------------------------");
        // C obj2=new C(355);
        // System.out.println("3---------------------");
        // A ob4=new A(0);
        System.out.println("The value in a of C: " + obj2.getA());
        // A obj2 = new C();
    }
}

// class A
// {
//     int i = 10;
//     public void value(){
//         System.out.println(i);
//     }
// }
 
// class B extends A
// {
//     int i = 20;
//     public void value(){
//         System.out.println(i);
//     }
// }
 
// public class App
// {
//     public static void main(String[] args)
//     {
//         A a = new B();
//         a.value();
//         System.out.println(a.i);
//     }
// }
//" alpha subsub  alpha subsub"
// class Alpha
// {
// 	static String s = " ";
// 	protected Alpha()
// 	{
// 		s += "alpha ";
// 	}
// }
// class SubAlpha extends Alpha
// {
// 	private SubAlpha()
// 	{
// 		s += "sub ";
// 	}
// }

// public class App extends Alpha
// {
// 	private App()
// 	{
// 		s += "subsub ";
//         System.out.println(s);
// 	}
// 	public static void main(String[] args)
// 	{
// 		new App();
// 		new App();
		
// 	}
// }

// class A{
//     static int a=5;//6
//     static{
//         System.out.println("Static of A");
//         a++;
//     }
//     {
//         System.out.println("non-Static of A");
//     }
// }
// class B extends A{
//     static{
//         System.out.println("Static of B");
//     }
//     B(){
//          System.out.println("Constructor of B");
//     }
// }
// class C extends B{
//     {
//         System.out.println("non-Static of C");
//     }
//     C(){
//         a= a + a++;//14
//         System.out.println("Constructor of C");
//     }
// }
// public class App{
//     public static void main(String[] args) {
//         // C c=new C();
//         B b=new C();
//         System.out.println(b.a);
        
//     }
// }


// class X
// {
//     int m = 1111;
 
//     {
//         m = m++;
//         System.out.println(m);
//     }
// }
 
// class Y extends X
// {
//     {
//         System.out.println(methodOfY());
//     }
 
//     int methodOfY()
//     {
//         return m-- + --m;
//     }
// }
 
// public class App
// {
//     public static void main(String[] args)
//     {
//         Y y = new Y();
//     }
// }