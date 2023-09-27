import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char map[][];

    static int dx[] = { 0, -1, 0, 1 };
    static int dy[] = { -1, 0, 1, 0 };

    static class Node {
        private int x;
        private int y;
        private int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        
        public int getLevel() {
            return level;
        }
        
        public void setLevel(int level) {
            this.level=level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Node sPos = null;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            if (sPos == null) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'S') {
                        sPos = new Node(i, j, 0);
                        break;
                    }
                }
            }
        }
        int ans = BFS(sPos);
        
        if(ans==-1)
            System.out.println("KAKTUS");
        else
            System.out.println(ans);
    }

    static int BFS(Node sPos) {
        Queue<Node> dochi = new ArrayDeque<>();
        boolean visited[][] = new boolean[R][C];
        dochi.offer(sPos);
        visited[sPos.getX()][sPos.getY()]=true;
        Node curPos;
        int curX;
        int curY;
        int curLevel=-1;
        int preLevel=-1;
        while (!dochi.isEmpty()) {
            curPos = dochi.poll();
            curX = curPos.getX();
            curY = curPos.getY();
            preLevel=curLevel;
            curLevel=curPos.getLevel();
            if(curLevel!=preLevel) {
//            	for (int i = 0; i < R; i++) {
//                	for (int j = 0; j < C; j++)
//                		System.out.print(map[i][j]);
//                	System.out.println();
//                }
//            	System.out.println();
            	water();
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C
                        || visited[nextX][nextY]
                        || map[nextX][nextY] == 'X' || map[nextX][nextY] == '*')
                    continue;
                if(map[nextX][nextY] == 'D')
                    return curLevel+1;
                dochi.offer(new Node(nextX,nextY,curLevel+1));
                visited[nextX][nextY]=true;
            }
            
        }
        return -1;
    }
    
    static void water() {
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j]
                		=='*') {
                    for(int k=0;k<4;k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
                            continue;
                        if(map[nextX][nextY]=='.')
                            map[nextX][nextY]='/';
                    }
                }
            }
        }
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j]=='/')
                	map[i][j]='*';
            }
        }
    }
}