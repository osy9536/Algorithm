class Solution {
    public static StringBuilder solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder(my_string);
        char c = my_string.charAt(num1);
        char c2 = my_string.charAt(num2);
        sb.replace(num1, num1+1, String.valueOf(c2));
        sb.replace(num2, num2+1, String.valueOf(c));
        return sb;
    }
}