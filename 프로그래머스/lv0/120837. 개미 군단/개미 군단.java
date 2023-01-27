class Solution {
    public static int solution(int hp) {
        int answer = 0;
        int damage= 5;
        while (hp>0) {
            if(3<=hp&&hp<5) damage=3;
            else if(hp<3) damage=1;
            answer += hp / damage;
            hp=hp%damage;
        }
        return answer;
    }
}