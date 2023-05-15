
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TITLE 농작물 수확하기
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < n; k++) {
            int size = Integer.parseInt(br.readLine());

            int left = size / 2;
            int right = size / 2;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                int[] arr = new int[size];
                String s = br.readLine();
                for (int j = 0; j < size; j++) {
                    arr[j] = s.charAt(j) - '0';
                }
                for (int j = left; j <= right; j++) {
                    sum += arr[j];
                }
                if (i >= size / 2) {
                    right--;
                    left++;
                } else {
                    right++;
                    left--;
                }
            }
            System.out.println("#"+(k+1)+" "+ sum);
        }
    }
}
