import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int lion = 0;
        int start = 0, end = 0;
        st = new StringTokenizer(br.readLine());
        int doll[] = new int[N]; 
        for (int i = 0; i < N; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }
        int dollNum = N+1;
        for (int i = 0; i < N; i++) {
        	end=i;
            if(doll[i]==1) {
            	lion++;
            }
            if(lion>=K) {
            	for(int j=start; j<=end;j++) {
            		if(doll[j]==1) {
            			if(lion>K)
            				lion--;
            			else if(lion==K) {
            				start=j;
            				break;
            			}
            		}
            	}
            	dollNum = dollNum<(end-start+1)?dollNum:(end-start+1);
            }
        }
        if(dollNum==N+1)
        	dollNum=-1;
        System.out.println(dollNum);
    }
}