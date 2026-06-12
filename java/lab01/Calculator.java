import java.util.Scanner;

public class Calculator
{
	public static void main(String []args)
	{
		System.out.print("Enter two numbers: ");
		Scanner scanner = new Scanner(System.in);
		double num1 = scanner.nextDouble();
		double num2 = scanner.nextDouble();

		System.out.print("Choose operation(+, -, *, /): ");
		String oper = scanner.next();

		Calculator myCalc = new Calculator();
		switch(oper)
		{
			case "+":
				System.out.println("result = " + myCalc.add(num1, num2));
				break;
			case "-":
				System.out.println("result = " + myCalc.sub(num1, num2));
				break;
			case "*":
				System.out.println("reslut = " + myCalc.mul(num1, num2));
				break;
			case "/":
				if(num2 == 0)
					System.out.println("Division by zero not allowd!");
				else
					System.out.println("reslut = " + myCalc.div(num1, num2));
				break;
			default:
				System.out.println("Invalid operation!");	
		}
	}

	double add(double a, double b)
		
	{
		return a+b;
	}

	double sub(double a, double b)
	{
		return a-b;
	}

	double mul(double a, double b)
	{
		return a*b;
	}

	double div(double a, double b)
	{
		return a/b;
	}
}
