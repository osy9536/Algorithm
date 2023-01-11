package String;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class manyWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[26];

        int max = -1;
        char result = '?';

        String s = sc.next();
        s = s.toUpperCase();

        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'A']++;
            if (max < num[s.charAt(i) - 'A']) {
                max = num[s.charAt(i) - 'A'];
                result = s.charAt(i);
            } else if (max == num[s.charAt(i) - 'A']) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
