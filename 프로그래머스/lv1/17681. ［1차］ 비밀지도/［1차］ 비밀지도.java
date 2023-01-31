import java.util.Arrays;

class Solution {
    public static StringBuilder[] solution(int n, int[] arr1, int[] arr2) throws NullPointerException {
        StringBuilder[] answer = new StringBuilder[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            answer[i]= new StringBuilder("");
            String s = "%" + arr1.length + "s";
            String  binary = String.format(s,Integer.toBinaryString(arr1[i] | arr2[i]));
            binary = binary.replace("1", "#");
            binary = binary.replace("0", " ");
            answer[i].append(binary);
        }
        return answer;
    }
}