package hust.soict.globalict.lab01;
import java.util.Scanner;
public class Ex6_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		int m = scanner.nextInt();
		System.out.print("Enter number of columns: ");
		int n = scanner.nextInt();
		

		int[][] a = new int[m][n];
		int[][] b = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0 ; j < n; j++) {
				a[i][j] = scanner.nextInt();
				
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0 ; j < n; j++) {
				b[i][j] = scanner.nextInt();
				
			}
		}
		
		int[][] c = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0 ; j < n; j++) {
				c[i][j] = a[i][j] + b[i][j];
				
			}
		}
		
		scanner.close();
	}

}
