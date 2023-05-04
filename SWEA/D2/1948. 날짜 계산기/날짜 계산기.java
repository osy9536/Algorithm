
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int firstM = Integer.parseInt(st.nextToken());
//            int firstD = Integer.parseInt(st.nextToken());
//            int secondM = Integer.parseInt(st.nextToken());
//            int secondD = Integer.parseInt(st.nextToken());
//            int fYear = 0;
//            int sYear = 0;
//            if (firstM > secondM || (firstM == secondM && firstD > secondD)) {
//                sYear++;
//            }
//            LocalDate firstDate = LocalDate.of(fYear, firstM, firstD);
//            LocalDate secondDate = LocalDate.of(sYear, secondM, secondD);
//
//            long x = ChronoUnit.DAYS.between(firstDate, secondDate);
//            System.out.println("#" + (i + 1) + " " + (fYear==sYear?x + 1:x));
//
//        }

        Scanner sc = new Scanner(System.in);
        int[] dayend = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int days = 0;
            int sm = sc.nextInt();
            int sd = sc.nextInt();
            int em = sc.nextInt();
            int ed = sc.nextInt();

            for(int m = sm; m<em; m++) {
                days += dayend[m];
            }
            days += (ed-sd+1);

            System.out.println("#" + tc + " " + days);
        }
    }
}
