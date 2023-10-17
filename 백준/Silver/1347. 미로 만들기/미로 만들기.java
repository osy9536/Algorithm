import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] in = br.readLine().toCharArray();
		int dir=0;
		int x[] = new int[N+1];
		int y[] = new int[N+1];
		int minX=0, minY=0, maxX=0, maxY=0;
		for(int i=1;i<=N;i++) {
			if(in[i-1]=='F') {
				x[i]=x[i-1]+dx[dir];
				y[i]=y[i-1]+dy[dir];
			} else {
				if(in[i-1]=='R') {
					dir=(dir+1)%4;
				} else {
					dir=(dir+3)%4;
				}
				x[i]=x[i-1];
				y[i]=y[i-1];
			}
			minX=minX<x[i]?minX:x[i];
			minY=minY<y[i]?minY:y[i];
			maxX=maxX>x[i]?maxX:x[i];
			maxY=maxY>y[i]?maxY:y[i];
		}
		int xSize=maxX-minX+1;
		int ySize=maxY-minY+1;
		char map[][] = new char[xSize+1][ySize+1];
		for(int i=0;i<=N;i++) {
			map[x[i]-minX][y[i]-minY]='.';
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<xSize;i++) {
			for(int j=0;j<ySize;j++) {
				if(map[i][j]!='.')
					map[i][j]='#';
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
