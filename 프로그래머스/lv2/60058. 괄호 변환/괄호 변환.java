import java.util.Objects;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        if(s.equals("")) return "";

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                u.append("(");
            }
            if (s.charAt(i) == ')') {
                cnt--;
                u.append(")");
            }
            if (cnt == 0) {
                v.append(s.substring(i + 1));
                break;
            }
        }
        if (Objects.equals(u.substring(0, 1), "(")) {
            u.append(solution(String.valueOf(v)));
            answer.append(String.valueOf(u));
        } else {
            answer.append("(");
            answer.append(solution(String.valueOf(v)));
            answer.append(")");
            String a =u.substring(1, u.length() - 1);
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)=='(') answer.append(")");
                else answer.append("(");
            }
        }


        return answer.toString();
    }
}