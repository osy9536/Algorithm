
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> answer = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!answer.isEmpty() && answer.getLast().value > num) {
                answer.removeLast();
            }
            answer.addLast(new Node(i, num));

            if (answer.getFirst().index <= i - l) {
                answer.removeFirst();
            }
            bw.write(answer.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
