class Solution {
    int solution(String s) {
        int answer = s.length();
        if (s.length() == 1) {
            return 1;
        }
        String c = "";

        for (int i = 1; i <= s.length(); i++) {

            int point = 1;
            StringBuilder sb = new StringBuilder();
            c = s.substring(0, i);
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    if (point > 1) sb.append(point);
                    sb.append(c).append(s.substring(j));
                    break;
                }
                if (c.equals(s.substring(j, j + i))) {
                    point++;
                } else {
                    if (point == 1) {
                        sb.append(c);
                    } else {
                        sb.append(point).append(c);
                    }
                    c = s.substring(j, j + i);
                    point = 1;
                }
                if (s.length() <= j + i) {
                    if (point == 1) {
                        sb.append(c);
                    } else {
                        sb.append(point).append(c);
                    }
                    c = s.substring(j, j + i);
                    point = 1;
                }
            }
            if (answer > sb.length() && sb.length() != 0) answer = sb.length();
        }

        return answer;
    }
}