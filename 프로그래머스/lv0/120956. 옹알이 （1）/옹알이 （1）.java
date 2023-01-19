class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0; i<babbling.length; i++){
            String[] splitBabbling = babbling[i].split("aya|ye|woo|ma");
            if(splitBabbling.length==0){
                answer++;
            }
        }
        return answer;
    }
}