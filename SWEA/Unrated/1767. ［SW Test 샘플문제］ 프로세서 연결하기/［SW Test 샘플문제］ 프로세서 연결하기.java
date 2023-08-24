
import java.util.*;
import java.io.*;

public class Solution {
	
	static int N, coreCnt;
	static int[][] MAP;
	static int answer = 10000, CON = 0;
	static ArrayList<Integer[]> cores;
	static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
            answer = 10000;
            CON = 0;
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];
			cores = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int val = Integer.parseInt(st.nextToken());
					MAP[i][j] = val;
					if(val==1 && !(i==0 || j==0 || i==N-1 || j==N-1)) cores.add(new Integer[] {i, j});
				}
			}
			
			coreCnt = cores.size();
			perm(MAP, 0, 0, 0);
			
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void perm(int[][] map, int sum, int cnt, int con) {
		if(cnt==coreCnt) {
			if(CON < con) {
				CON = con;
				answer = sum;
			}
			if(CON == con &&  sum < answer) {
				answer = sum;
			}
			return;
		}
		
		//남은 core 모두 연결해도 answerCnt보다 작은 경우
		//if(con+(coreCnt-cnt) < CON) return;
		
		for(int i=0; i<4;i++) {
			int[][] newMap = cloneMap(map);
			int len = linkCore(newMap, cores.get(cnt), i); 
			if(len>0) perm(newMap, sum+len, cnt+1, con+1);
		}
		 perm(map, sum, cnt+1, con);
	}
	
	public static int linkCore(int[][] map, Integer[] pos, int dir) {
		int len = 0;

		int nr = pos[0];
		int nc = pos[1];
		
		while(true) {
			nr += d[0][dir];
			nc += d[1][dir];
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			len++;			
			if(map[nr][nc]>0) {
				len = -1;
				break;
			}
		}
		
		if(len!=-1) {
			nr = pos[0];
			nc = pos[1];
			
			while(true) {
				nr += d[0][dir];
				nc += d[1][dir];
				if(nr<0 || nr>=N || nc<0 || nc>=N) break;
				map[nr][nc] = 2;
			}
		}
		
		return len;
	}
	
	public static int[][] cloneMap(int[][] map) {
		int[][] newMap = new int[N][N];
		for(int i=0;i<N;i++) newMap[i] = map[i].clone();
		
		return newMap;
	}

}