import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int num[] = new int[100001];
		int start=0, cnt=0, max=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(++num[arr[i]]<=K)
				cnt++;
			else {
				for(int j=start;j<i;j++) {
					num[arr[j]]--;
					cnt--;
					if(num[arr[i]]<=K) {
						start=j+1;
						cnt++;
						break;
					}
				}
			}
			max=max>cnt?max:cnt;
		}
		System.out.println(max);
	}
}
