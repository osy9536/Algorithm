class Solution {
  public long solution(long n){
        long first = (long) Math.sqrt(n);
        long answer = 0;
        if( first *first==n){
            answer = (first + 1) * (first + 1);
        }
        else answer=-1;
        return answer;
    }
}
