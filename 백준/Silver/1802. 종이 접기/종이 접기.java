import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case=0;test_case<T;test_case++) {
			char in[] = br.readLine().toCharArray();
			int mid = in.length/2;
			boolean isPossible= true;
			while(mid>0) {
				for(int i=1;i<=mid;i++) {
					if(in[mid-i]==in[mid+i]) {
						isPossible=false;
						break;
					}
				}
				mid/=2;
				if(!isPossible)
					break;
			}
			if(isPossible)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
}
