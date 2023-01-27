class Solution {
    public String solution(int a, int b){
        String answer = "";
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day=0;

        for(int k=1;k<a;k++){
            day+=month[k-1];

        }
        day+=b-1;
        answer=week[day%7];
        return answer;
    }
}