
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Base64 Decoder
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int decode=0;
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                    decode = s.charAt(j) - 65;
                } else if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    decode = s.charAt(j) - 71;
                } else if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    decode = s.charAt(j) + 4;
                } else if (s.charAt(j)=='+') {
                    decode = s.charAt(j) + 19;
                } else if (s.charAt(j)=='/') {
                    decode = s.charAt(j) + 17;
                }
                String binary = Integer.toBinaryString(decode);
                StringBuilder add = new StringBuilder();
                if (binary.length() < 6) {
                    for (int k = 0; k < 6-binary.length(); k++) {
                        add.append("0");                        
                    }
                }
                sb.append(add).append(binary);
            }
            int m = 0;
            StringBuilder decode = new StringBuilder();
            while (m < sb.length()) {
                int sub = Integer.parseInt(sb.substring(m, Math.min(m + 8, sb.length())),2);
                char c = (char) (sub);
                decode.append(c);
                m += 8;
            }
            System.out.println("#"+(i+1)+" "+decode);
        }
    }
}