import java.util.Base64;
import java.util.Scanner;

// Base64 Decoder
// 가랏! RC카!
// 간단한 소인수분해
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            byte[] bytes = s.getBytes();

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodeBytes = decoder.decode(bytes);
            System.out.println("#" + (i + 1) + " " + new String(decodeBytes));
        }
    }
}