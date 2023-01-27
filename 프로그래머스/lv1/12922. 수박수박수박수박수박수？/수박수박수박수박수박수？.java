class Solution {
    public static String  solution(int n){
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(answer.toString().equals("")){
                answer.append("수");
            }
            else if(answer.charAt(i-1)=='수'){
                answer.append("박");
            } else if (answer.charAt(i-1)=='박') {
                answer.append("수");
            }
        }
        return answer.toString();
    }
}