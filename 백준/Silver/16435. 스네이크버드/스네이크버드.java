
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] fruits = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			
			fruits[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);
		// 1 3 5 6 7
		// 5
		for(int i = 0; i<N; i++) {
			if(fruits[i]<=L)L++;
		}
		System.out.println(L);
	}
}
