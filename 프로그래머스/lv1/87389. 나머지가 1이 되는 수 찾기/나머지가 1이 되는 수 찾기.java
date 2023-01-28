class Solution {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (i == n / 2+1) {
                answer=n-1;
                break;
            }
            if(n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}