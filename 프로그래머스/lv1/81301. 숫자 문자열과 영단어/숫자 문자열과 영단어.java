import java.util.*;


/*string 받고 각 인덱스 추출 후 정렬, 정렬된 인덱스와 */
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




