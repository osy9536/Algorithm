class Solution {
    public static String solution(String s) {
        String answer = "";
        int max = 0;
        int min = 0;
        String[] arr = s.split(" ");
        max = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        min = Math.min(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        if (arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                if (Integer.parseInt(arr[i]) > max) max=Integer.parseInt(arr[i]);
                else if(Integer.parseInt(arr[i])<min) min = Integer.parseInt(arr[i]);
            }
        }
        answer += min;
        answer += " ";
        answer += max;

        return answer;
    }
}