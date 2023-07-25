

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        int[] arr = new int[26];
        if (first.length()!=second.length()) return false;
        for(char c : first.toCharArray()){
            arr[c-'a']++;
        }
        for (char c : second.toCharArray()) {
            arr[c-'a']--;
            if(arr[c-'a']<0) return false;
        }

        return true;
        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
