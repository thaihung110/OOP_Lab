package hust.soict.globalict.lab01;
import java.util.Scanner;
public class Equation_ {
	static void linear_equation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter 'a': ");
		double a = scanner.nextDouble();
		
		System.out.print("Enter 'b': ");
		double b = scanner.nextDouble();
		
		if (a == 0) {
			if (b == 0) {
				System.out.println("Infinite solution");
			}
			else {
				System.out.println("No solution");
			}
		}
		else {
			System.out.printf("The root of the equation is: %.2f\n\n\n", (-b / a));
		}
		
		scanner.close();
	}
	
	static void linear_equation_system() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter coefficients for the system of equations:");
        System.out.println("ax + by = e");
        System.out.println("cx + dy = f");
        
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        System.out.print("d: ");
        double d = scanner.nextDouble();

        System.out.print("e: ");
        double e = scanner.nextDouble();

        System.out.print("f: ");
        double f = scanner.nextDouble();
        
        double denominator = a * d - b * c;
        
        if (denominator == 0) {
            System.out.println("The equation has no solution or has infinitely many solutions.");
        } else {
            double x = (e * d - b * f) / denominator;
            double y = (a * f - e * c) / denominator;

            System.out.println("Solution: x = " + x + ", y = " + y);
        }
        
        
        System.out.printf("\n\n\n");
		
		scanner.close();
	}
	
	static void second_degree_equation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Enter 'a': ");
		double a = scanner.nextDouble();
		System.out.printf("Enter 'b': ");
		double b = scanner.nextDouble();
		System.out.printf("Enter 'c': ");
		double c = scanner.nextDouble();
		
		if (a == 0) {
			if (b == 0) {
				if (c == 0) System.out.println("Infinite solution");
				else System.out.println("No solution");
			}
			else {
				System.out.printf("The solution of the equation is: %.2f", -c / b);
			}
		}
		
		else {
			double delta = b * b - 4 * a * c;
			if (delta < 0) {
				System.out.println("No solution");
			}
			else if (delta == 0) {
				System.out.printf("The equation has double solution: x1 = x2 = %.2f\n", -b / (2 * a));
			}
			else {
				System.out.printf("The equation has double solution:\n"
								  + "x1 = %.2f\n"
								  + "x2 = %.2f\n", (-b - Math.sqrt(delta)) / (2 * a), (-b + Math.sqrt(delta)) / (2 * a));
			}
			
		}
		
		scanner.close();
	}
	
	public static void main(String[] args) {
//		linear_equation();
//		linear_equation_system();
		second_degree_equation();
	}
}
