class Solution {
    public static String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        char[] win = {'0', '2', '5'};
        for (int i = 0; i < rsp.length(); i++) {
            char c = rsp.charAt(i);
            if (win[0] == c) {
                answer.append(win[2]);
            } else if (win[1] == c) {
                answer.append(win[0]);
            } else answer.append(win[1]);
        }
        return answer.toString();
    }
}