class Solution {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int l = 10;
        int r = 12;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==0) numbers[i] = 11;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                l=numbers[i];
                answer.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                r = numbers[i];
                answer.append("R");
            } else {
                if (num(l, r, numbers[i], hand).equals("R")) {
                    r = numbers[i];
                    answer.append(num(l, r, numbers[i], hand));
                }
                else {
                    l = numbers[i];
                    answer.append(num(l, r, numbers[i], hand));
                }
            }
        }
        return answer.toString();
    }

    static String num(int l, int r, int numbers, String hand) {
        int lNum = Math.abs(numbers - l) / 3 + Math.abs(numbers - l) % 3;
        int rNum = Math.abs(numbers - r) / 3 + Math.abs(numbers - r) % 3;
        if (lNum == rNum) {
            if(hand.equals("right")) return "R";
            else return "L";
        } else {
            if(lNum>rNum) return "R";
            else return "L";
        }
    }
}