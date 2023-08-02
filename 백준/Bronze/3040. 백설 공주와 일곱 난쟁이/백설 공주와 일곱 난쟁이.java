
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

// 백설 공주와 일곱 난쟁이
// bronze 2
public class Main {
	static int[] arr= new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
			sum+=a;
		}

		int[] arr2 = Arrays.copyOf(arr, 9);
		int num = sum-100;
		check(num);
		for(int i = 0; i<9; i++) {
			if(arr[i]!=-1) {
				System.out.println(arr[i]);
			}
		}
	}
	static void check (int num) {
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++){
				if(i==j)continue;
				if(arr[i]+arr[j]==num) {
					arr[i]=-1;
					arr[j]=-1;
				}
			}
		}
	}
}
