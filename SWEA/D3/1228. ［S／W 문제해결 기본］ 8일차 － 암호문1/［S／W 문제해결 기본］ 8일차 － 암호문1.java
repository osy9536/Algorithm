
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int k = 1; k<=10; k++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> a = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				int location=0,nextNum=0;
				if(s.equals("I")) {
					location = Integer.parseInt(st.nextToken());
					nextNum = Integer.parseInt(st.nextToken());
				}
				
				for(int i = 0; i<nextNum; i++) {
					a.add(location++,Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+k+" ");
			for(int i = 0; i<10; i++) {
				System.out.print(a.get(i)+ " ");
			}
			System.out.println();
		}
	}
}