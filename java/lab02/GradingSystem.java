import java.util.Scanner;

public class GradingSystem
{
	public static void main(String [] args)
	{
		double score, total, grade;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your total: ");
		total = scanner.nextDouble();
		if(total < 0)
		{
			System.out.println("Invalid number!!");
			return;
		}


		System.out.print("Enter your score: ");
		score = scanner.nextDouble();
		if(score < 0 || score > total)
		{
			System.out.println("Invalid score!");
			return;
		}

		grade = (score / total) * 100;
		if(grade>0 && grade<60)
		{
			System.out.println("Grade F");
		}
		else if(grade>=60 && grade<70)
		{
			System.out.println("Grade D");
		}
		else if(grade>=70 && grade<80)
		{
			System.out.println("Grade C");
		}
		else if(grade>=80 && grade<90)
		{
			System.out.println("Grade B");
		}
		else
		{
			System.out.println("Grade A");	
		}

	}
}
