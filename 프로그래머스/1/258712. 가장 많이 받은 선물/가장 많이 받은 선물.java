import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] answers = new int[friends.length];
        
        int[][] giftNum = new int[friends.length][friends.length];
        int[] giftPM = new int[friends.length];
        
        for(int i = 0; i<gifts.length; i++){
            String[] s = gifts[i].split(" " );
            int sender = 0;
            int receiver = 0;
            for(int j = 0; j<friends.length; j++){
                if(friends[j].equals(s[0])){
                    sender = j;
                }
                if(friends[j].equals(s[1])){
                    receiver = j;
                }
            }
            
            giftNum[sender][receiver]++;
        }
        
        for(int i = 0; i<friends.length; i++){
            int rec = 0;
            int sen = 0;
            for(int j = 0; j<friends.length; j++){
                sen+=giftNum[i][j];
                rec+=giftNum[j][i];
            }
            giftPM[i] = sen-rec;
        }
        
        for(int i = 0; i<friends.length; i++){
            for(int j = 0; j<friends.length; j++){
                if(i==j)continue;
                
                if(giftNum[i][j]>giftNum[j][i]){
                    answers[i]++;
                }
                if(giftNum[i][j]==giftNum[j][i]){
                    if(giftPM[i]>giftPM[j]){
                        answers[i]++;
                    }
                }
            }
        }
        for(int i = 0; i<friends.length; i++){
            answer = Math.max(answer, answers[i]);
        }
        
        return answer;
    }
}