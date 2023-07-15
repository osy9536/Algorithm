
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            if(Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);

    }
}
