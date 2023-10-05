import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int button[] = new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			button[i]=Integer.parseInt(st.nextToken());
		int result[] = new int[N];
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(button[i]!=result[i]) {
				for(int j=i;j<i+3;j++) {
					if(j>=N) continue;
					if(result[j]==1)
						result[j]=0;
					else
						result[j]=1;
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
