class Solution {
    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        solved(numbers, 1, 0, 0, target);
        solved(numbers, -1, 0, 0, target);
        return answer;
    }

    private static void solved(int[] numbers, int sign, int sum, int depth, int target) {
        sum += numbers[depth] * sign;
        if (depth == numbers.length-1) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        solved(numbers, sign, sum, depth + 1, target);
        solved(numbers, sign * -1, sum, depth + 1, target);
    }
}