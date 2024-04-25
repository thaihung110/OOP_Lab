package hust.soict.globalict.lab01;
import java.util.Scanner;
public class Operator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		double num1 = scanner.nextDouble();
		
		System.out.println("Enter second number: ");
		double num2 = scanner.nextDouble();
		
		
		System.out.printf("The sum is %.2f\n", (num1 + num2));
		System.out.printf("The difference is %.2f\n", Math.abs(num1 - num2));
		System.out.println("The product is " + (num1 * num2));
		
		if (num2 != 0) System.out.printf("The quotient is %.2f", (num1 / num2));
		else System.out.println("Not appropriate equation");
		
		scanner.close();
		
	}
	
}
