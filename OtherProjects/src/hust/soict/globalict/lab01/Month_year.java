package hust.soict.globalict.lab01;
import java.util.Scanner;
public class Month_year {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter the month: ");
			String month = scanner.nextLine();
			System.out.print("Enter the year: ");
			int year = scanner.nextInt();
			scanner.nextLine();
			int flag = 0;
			
			String lowerMonth = month.toLowerCase();
			
			if (lowerMonth.equals("jan") || lowerMonth.equals("jan.") || lowerMonth.equals("january") 
			|| month.equals("1") || lowerMonth.equals("mar.") || lowerMonth.equals("mar") || lowerMonth.equals("march")
			|| lowerMonth.equals("3") || lowerMonth.equals("may") || lowerMonth.equals("5") || lowerMonth.equals("july")
			|| lowerMonth.equals("jul") || lowerMonth.equals("7") || lowerMonth.equals("aug.") || lowerMonth.equals("aug") 
			|| lowerMonth.equals("august") || lowerMonth.equals("8") || lowerMonth.equals("june") || lowerMonth.equals("jun") 
			|| lowerMonth.equals("6") || lowerMonth.equals("october") || lowerMonth.equals("oct") 
			|| lowerMonth.equals("oct.") || lowerMonth.equals("10") || lowerMonth.equals("december")
			|| lowerMonth.equals("dec") || lowerMonth.equals("dec.") || lowerMonth.equals("12")) {
				if (year >= 1000) flag = 1;
				System.out.println("Number of days: 31");
			}
			
			else if (lowerMonth.equals("april") || lowerMonth.equals("apr") || lowerMonth.equals("apr.")
					|| lowerMonth.equals("4") || lowerMonth.equals("june") || lowerMonth.equals("jun")
					|| lowerMonth.equals("6") || lowerMonth.equals("september") || lowerMonth.equals("sept.")
					|| lowerMonth.equals("sept") || lowerMonth.equals("9") || lowerMonth.equals("november")
					|| lowerMonth.equals("nov.") || lowerMonth.equals("nov") || lowerMonth.equals("11")) {
				if (year >= 1000) flag = 1;
				System.out.println("Number of days: 30");
			}
			
			else if (lowerMonth.equals("february") || lowerMonth.equals("feb") || lowerMonth.equals("feb.")
					|| lowerMonth.equals("2")) {
				if (year >= 1000) flag = 1;
				if (year % 4 == 0) {
					if (year % 100 == 0 && !(year % 400 == 0)) {
						System.out.println("Number of days: 28");
					}
					else {
						System.out.println("Number of days: 29");
					}
				}
	
			}
			
			if (flag == 1) break;
			else {
				System.out.println("Wrong input!");
			}
		}
		
		scanner.close();
	}

}
