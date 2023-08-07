
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<=n; i++) {
			q.add(i);
		}
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			if(cnt==m) {
				cnt=0;
				sb.append(q.poll()+", ");
			}else {
				q.add(q.poll());
			}
			cnt++;
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.print(sb.toString());
	}
}
