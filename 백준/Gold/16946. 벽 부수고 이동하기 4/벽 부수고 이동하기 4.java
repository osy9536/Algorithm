
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽 부수고 이동하기 4
// gold 2
public class Main {

    static int N,M;
    static int[][] map;
    static int[][] resultMap;
    static int[][] group;
    static int[][] nextDir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int groupNum;
    static List<Integer> groupMemberCount;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        resultMap = new int[N][M];
        group = new int[N][M];
        groupMemberCount = new ArrayList<>();
        groupMemberCount.add(0);
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1) continue; //벽
                if(group[i][j] != 0) continue; // 이미 그룹이 있음
                groupMemberCount.add(getGroup(i,j));
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                sb.append(getResult(i,j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int getGroup(int n,int m) {
        Queue <int[]> q = new ArrayDeque<>();
        q.add(new int[] {n,m});
        int visitCount = 0; //그룹에서 이동할수 있는칸 수 카운트
        groupNum++;
        while(!q.isEmpty()) {
            int [] now = q.poll();
            int nowI = now[0];
            int nowJ = now[1];
            if(group[nowI][nowJ]!=0) continue; // 이미 그룹이 있음
            group[nowI][nowJ] = groupNum;
            visitCount++;
            for(int k=0;k<4;k++) {
                int nextI = nowI + nextDir[k][0];
                int nextJ = nowJ + nextDir[k][1];
                if(nextI < 0 || nextI >=N || nextJ <0 || nextJ >=M) continue;
                if(group[nextI][nextJ]!=0) continue; // 탐색할 칸이 이미 그룹이 있음
                if(map[nextI][nextJ]==0) { // 그룹없는 빈칸
                    q.add(new int[] {nextI,nextJ});
                }
            }
        }
        return visitCount;
    }
    public static int getResult(int i,int j) {
        if(map[i][j]==0) return 0;
        HashSet<Integer> visitGroup = new HashSet<>(); // 그룹중복방지용 
        int visitCount = 1; // 벽을 부수므로 1
        for(int k=0;k<4;k++) { // 사방 4칸의 그룹의 갈수있는 칸 수 더하기
            int nextI = i + nextDir[k][0];
            int nextJ = j + nextDir[k][1];
            if(nextI < 0 || nextI >=N || nextJ <0 || nextJ >=M) continue;
            if(map[nextI][nextJ]==0 && !visitGroup.contains(group[nextI][nextJ])) {
                visitGroup.add(group[nextI][nextJ]); // 방문한 그룹 체크
                visitCount += groupMemberCount.get(group[nextI][nextJ]); // 해당그룹의 칸 수
            }
        }
        return visitCount%10;
    }
}
