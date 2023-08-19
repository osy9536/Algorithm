
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 이모티콘
// gold 4
public class Main {
    public static class Emoticon {
        int screen, clip, depth;

        public Emoticon(int screen, int clip, int depth) {
            super();
            this.screen = screen;
            this.clip = clip;
            this.depth = depth;
        }
    }

    public static int S, answer;
    public static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        visited = new boolean[S + 1][S + 1];
        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.offer(new Emoticon(1, 0, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            Emoticon emoticon = q.poll();

            // BFS는 먼저 들어온게 가장 빠름
            if (emoticon.screen == S) {
                answer = emoticon.depth;
                return;
            }

            if (!visited[emoticon.screen][emoticon.screen]) {
                visited[emoticon.screen][emoticon.screen] = true;
                q.offer(new Emoticon(emoticon.screen, emoticon.screen, emoticon.depth + 1));
            }
            // 클립보드가 비어있지 않을때
            if (emoticon.clip > 0 &&
                    emoticon.screen + emoticon.clip <= S &&
                    !visited[emoticon.screen + emoticon.clip][emoticon.clip]) {
                visited[emoticon.screen + emoticon.clip][emoticon.clip] = true;
                q.offer(new Emoticon(emoticon.screen + emoticon.clip, emoticon.clip, emoticon.depth + 1));
            }

            // 명령어 3 : 삭제
            if (emoticon.screen - 1 > 0 && !visited[emoticon.screen - 1][emoticon.clip]) {
                visited[emoticon.screen - 1][emoticon.clip] = true;
                q.offer(new Emoticon(emoticon.screen - 1, emoticon.clip, emoticon.depth + 1));
            }
        }
    }
}
