import java.util.Scanner;

public class UserInput{
    public static void main(String[] args) {
        System.out.println("--Calculator");
        Scanner sc = new Scanner(System.in);
        char user_choice='y';
        while(user_choice=='y' || user_choice=='Y'){
            System.out.print("Enter first number : ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number : ");
            int num2 = sc.nextInt();
            System.out.print("Enter operator +,-,*,/ : ");
            char opr = sc.next().charAt(0);
            if(opr=='+'){
                System.out.println(num1+num2);
            }
            else if(opr=='-'){
                System.out.println(num1-num2);
            }
            else if(opr=='*'){
                System.out.println(num1*num2);
            }
            else if(opr=='/'){
                System.out.println(num1/num2);
            }
            else{
                System.out.println("Invalid input");
            }
            System.out.print("Press y for continue : ");
            user_choice = sc.next().charAt(0);
            if(user_choice=='y' || user_choice=='Y'){
                continue;
            }
            else{
                break;
            }
        }
    }
}