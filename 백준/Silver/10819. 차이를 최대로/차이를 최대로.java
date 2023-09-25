import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[], maxSum;
	static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        	arr[i]=Integer.parseInt(st.nextToken());
        dfs(0,0,0);
        System.out.println(maxSum);
        
    }
    static void dfs(int cnt, int pre, int sum) {
    	if(cnt==N) {
    		maxSum=maxSum>sum?maxSum:sum;
    		return;
    	}
    	for(int i=0;i<N;i++) {
    		if(visited[i]) continue;
    		visited[i]=true;
    		if(cnt>0)
    			sum+=Math.abs(arr[i]-pre);
    		dfs(cnt+1, arr[i], sum);
    		if(cnt>0)
    			sum-=Math.abs(arr[i]-pre);
    		visited[i]=false;
    	}
    }
}