import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    enum Num {
        ZRO("ZRO"), ONE("ONE"), TWO("TWO"), THR("THR"), FOR("FOR"),
        FIV("FIV"), SIX("SIX"), SVN("SVN"), EGT("EGT"), NIN("NIN");

        private final String name;

        Num(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // # 무시
            String s = st.nextToken();

            Node[] nodes = new Node[Num.values().length];
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String num = st.nextToken();
                int index = Num.valueOf(num).ordinal();
                if (nodes[index] == null) {
                    nodes[index] = new Node(1, num);
                } else {
                    nodes[index].cnt++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Num num : Num.values()) {
                sb.append(repeat(nodes[num.ordinal()]));
            }
            System.out.printf("#%d%n%s%n", i + 1, sb);
        }
    }

    static String repeat(Node node) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < node.cnt; i++) {
            sb.append(node.name).append(" ");
        }
        return sb.toString();
    }

    static class Node {
        public int cnt;
        public String name;

        Node(int cnt, String name) {
            this.cnt = cnt;
            this.name = name;
        }
    }
}
