class Solution {
    public int solution(String s) {
        int answer = s.length();
        int length = s.length();

        // 문자열을 자를 수 있는 단위
        for (int unit = 1; unit <= length / 2; unit++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;
            String prev = s.substring(0, unit);

            // 문자열을 자르고 비교
            for (int i = unit; i < length; i += unit) {
                String current = "";

                // 현재 자르는 문자열이 남은 문자열보다 길이가 길 경우 예외처리
                if (i + unit > length) {
                    current = s.substring(i);
                } else {
                    current = s.substring(i, i + unit);
                }

                // 이전 문자열과 같으면 카운트를 증가시키고, 아니면 문자열을 만들어줌
                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 문자열 처리
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            // 압축한 문자열의 길이가 더 짧으면 업데이트
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}