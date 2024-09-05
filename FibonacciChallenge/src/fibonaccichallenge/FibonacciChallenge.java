package fibonaccichallenge;

import java.util.Scanner;

public class FibonacciChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        System.out.println("=========================================================");
        System.out.println("0 : To exit");
        System.out.println("1 : To enter number and find the next number in the Fibonacci sequence");
        System.out.println("2 : To enter sequence of numbers and find the next number in the Fibonacci sequence");
        System.out.println("=========================================================");
        while(!exit){
            System.out.print("# Enter the number of the operation you want to perform: ");
            int op = scanner.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Exit.");
                    exit = true;
                    break;
                case 1:
                    numberInput(scanner);
                    break;
                case 2:
                    sequenceInput(scanner);
                    break;

                default:
                    System.out.println("Invalid input!");
                    break;
            }

            System.out.println("\n-------------------------------\n");
        }

        scanner.close();
            
    }
    
    private static void numberInput(Scanner scanner){
        System.out.print("Enter number to find the next number in the Fibonacci sequence: ");
        int n = scanner.nextInt();
        String invalidMessage = "Invalid input, Please enter a positive integer.";
        if (n <= 0) {
            System.out.println(invalidMessage);
        } else {
            int num1 = 0, num2 = 1;
            String result = "Fibonacci Sequence up to " + n + " terms:";
            while(num2 <= n){
                result += num1 + " ";
                int temp = num1;
                num1 = num2;
                num2 += temp;
            }
            if(num1 == n){
                System.out.println(result + n);
                System.out.println("Next number in the sequence: " + num2);
            }
            else
                System.out.println(invalidMessage);
        }
    }
    
    private static void sequenceInput(Scanner scanner){
        System.out.println("Enter any Fibonacci sequence (if sequence end enter -1)");
        int num1 = 0, num2 = 0;
        int count = 0;
        String invalidMessage = "Invalid Fibonacci sequence!";
        while(true){
            System.out.print("* ");
            int n = scanner.nextInt();
            if(n == -1){
                break;
            }
            if(count <= 1){
                if(!isValid(num1, n)){
                    System.out.println(invalidMessage);
                    break;
                }
                count++;
                num1 = n;
            }else if(num2 != n){
                System.out.println(invalidMessage);
                break;
            }
            int temp = num1;
            if(count > 2)
                num1 = num2;
            else if(count == 2)
                count++;
            num2 += temp;
        }
        if(count <= 1){
            System.out.println("The sequence must contain at least two numbers.");
        }else{
            System.out.println("Next number in the sequence: " + num2);
        }    
    }
    
    private static boolean isValid(int pre, int n) {
        int num1 = 0, num2 = 1;
        if (n < 0) {
            return false;
        } 
        while(num2 < n){
            int temp = num1;
            num1 = num2;
            num2 += temp;
        }
        return (pre == 0 || num1 == pre) && num2 == n;
    }
}
