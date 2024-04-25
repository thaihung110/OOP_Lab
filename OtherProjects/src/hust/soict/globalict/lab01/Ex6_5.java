package hust.soict.globalict.lab01;
import java.util.Scanner;
import java.util.Arrays;
public class Ex6_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n ; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < n ; i++) {
			System.out.print(arr[i] + " ");
		}
		scanner.close();
	}

}
