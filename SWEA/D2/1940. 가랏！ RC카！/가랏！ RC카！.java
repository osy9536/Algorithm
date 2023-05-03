
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int m = Integer.parseInt(br.readLine());
            int speed = 0;
            int distance = 0;
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                switch (command) {
                    case 0:
                        break;
                    case 1:
                        speed += Integer.parseInt(st.nextToken());
                        break;
                    case 2:
                        speed -= Integer.parseInt(st.nextToken());
                        break;
                }
                if(speed<0) speed = 0;
                distance += speed;
            }
            System.out.println("#"+(i+1)+" "+distance);
        }
    }
}