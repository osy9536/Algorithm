import java.io.*;
import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int inC,outC;
    static boolean[] visited;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int additionalNum = 0;
        
        int[] out = new int[1000001];
        int[] in = new int[1000001];
        Arrays.fill(out,-1);
        Arrays.fill(in,-1);

        for(int i = 0; i<edges.length; i++){
            out[edges[i][0]]++;
            in[edges[i][1]]++;
        }
        
        int idx = 0;
        for(int i = 1;i<1000001; i++){
            if(out[i] != -1 || in[i] != -1){
                idx= i+1;
            }
        }
        
        for(int i = 1; i<idx; i++){
            if(out[i]>0 && in[i] ==-1){
                additionalNum = i;
            }
        }
        
        list = new List[idx];
        for(int i = 0; i<idx; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
        }
        
        
        visited = new boolean[idx];
        
        for(int i = 0; i<list[additionalNum].size(); i++){
            int a = list[additionalNum].get(i);
            if(visited[a]) continue;
            visited[a] = true;
            inC = 1;
            outC = 0;
            dfs(a, a);
            
            if(inC==outC){
                answer[1]++;
            }
            if(inC>outC){
                answer[2]++;
            }
            if(inC<outC){
                answer[3]++;
            }
        }
        answer[0] = additionalNum;
        return answer;
    }
    static void dfs(int num, int start){
        for(int i = 0; i<list[num].size(); i++){
            int next = list[num].get(i);
            outC++;
            if(visited[next]) continue;
            visited[next] = true;
            if(num == next) continue;
            if(next==start) break;
            inC++;
            dfs(next, start);
        }
    }
}