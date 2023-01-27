import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <2*participant.length-1; i++) {
            if(i<participant.length){
                if (map.containsKey(participant[i])) {
                    map.remove(participant[i]);
                } else map.put(participant[i], 1);
            }
            else {
                if (map.containsKey(completion[i-participant.length])) {
                    map.remove(completion[i-participant.length]);
                } else map.put(completion[i-participant.length], 1);
            }

        }
        answer=map.toString();
        answer=answer.split("=")[0];
        return answer.substring(1,answer.length());
    }
}