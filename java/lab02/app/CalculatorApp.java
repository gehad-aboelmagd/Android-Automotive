package app;

import java.util.Scanner;
import calculator.Operation;

class CalculatorApp
{
    public static void main(String []args)
    {
        Scanner scan = new Scanner(System.in);
        double num1, num2, result;
        String oper;

        System.out.println("Enter two numbers:");
        num1 = scan.nextDouble();
        num2 = scan.nextDouble();

        System.out.println("Enter Operation(+, -, *, /):");
        oper = scan.next();

        Operation component = OperationFactory.getComponent(oper);
        if(component != null)
        {
            result = component.calculate(num1, num2);
            System.out.printf("%.2f %s %.2f = %.2f\n", num1, oper, num2, result);
        }
        else
        {
            System.out.println("Invalid Operation");
        }

        scan.close();
    }
}