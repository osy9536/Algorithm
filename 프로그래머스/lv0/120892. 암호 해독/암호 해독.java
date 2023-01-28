class Solution {
    public static StringBuilder solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();
        if (cipher.length() >= code) {

        }
        for (int i = code-1; i < cipher.length(); i++) {
            if((i+1)%code==0){
                answer.append(cipher.charAt(i));
            }
        }
        return answer;
    }
}