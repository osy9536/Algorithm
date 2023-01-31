class Solution {
    public static int solution(int n) {
        return test(n);
    }
    static int test(int n) {
        int answer = 0;
        int cnt = 1;
        int tmp = n;
        while (true) {
            n=tmp;
            if (cnt > n) {
                break;
            }
            int num = cnt;
            while (true) {
                n -= num;
                num++;
                if (n == 0) {
                    answer++;
                    cnt++;
                    break;
                } else if (n < 0) {
                    cnt++;
                    break;
                }
            }
        }
        return answer;
    }
}