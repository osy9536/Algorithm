import java.util.Arrays;

class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        int max = 0;
        Arrays.sort(numbers);
        if (numbers[0] * numbers[1] > numbers[numbers.length - 1] * numbers[numbers.length - 2]) {
            answer=numbers[0] * numbers[1];
        }
        else answer=numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return answer;
    }
}