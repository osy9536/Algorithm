
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkNum = 0;
    static int[] check;
    static int[] myArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numLength = Integer.parseInt(st.nextToken());
        int secretLength = Integer.parseInt(st.nextToken());
        int answer = 0 ;

        char[] secret = new char[secretLength];
        secret = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        check = new int[4];
        myArr = new int[4];
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i]==0) checkNum++;
        }
        for (int i = 0; i < secretLength; i++) {
            Add(secret[i]);
        }
        if(checkNum==4) answer++;
        for (int i = secretLength; i < numLength; i++) {
            int j = i - secretLength;
            Add(secret[i]);
            Remove(secret[j]);
            if (checkNum == 4) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();

    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0]==check[0]) checkNum++;
                break;

            case 'C':
                myArr[1]++;
                if(myArr[1]==check[1]) checkNum++;
                break;

            case 'G':
                myArr[2]++;
                if(myArr[2]==check[2]) checkNum++;
                break;

            case 'T':
                myArr[3]++;
                if(myArr[3]==check[3]) checkNum++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if(myArr[0]==check[0]) checkNum--;
                myArr[0]--;
                break;

            case 'C':
                if(myArr[1]==check[1]) checkNum--;
                myArr[1]--;
                break;

            case 'G':
                if(myArr[2]==check[2]) checkNum--;
                myArr[2]--;
                break;

            case 'T':
                if(myArr[3]==check[3]) checkNum--;
                myArr[3]--;
                break;
        }
    }
}
