import java.util.*;


class Solution {
    public static int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }
}




