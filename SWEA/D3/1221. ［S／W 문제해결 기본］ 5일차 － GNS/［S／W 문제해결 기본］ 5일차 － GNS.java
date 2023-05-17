
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TITLE [S/W 문제해결 기본] 5일차 - GNS
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String s2 = st.nextToken();

            Node[] nodes = new Node[10];
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                switch (st.nextToken()) {
                    case "ZRO":
                        if (nodes[0] == null) {
                            nodes[0] = new Node(1, "ZRO");
                        } else {
                            nodes[0].cnt++;
                        }
                        break;
                    case "ONE":
                        if (nodes[1] == null) {
                            nodes[1] = new Node(1, "ONE");
                        } else {
                            nodes[1].cnt++;
                        }
                        break;
                    case "TWO":
                        if (nodes[2] == null) {
                            nodes[2] = new Node(1, "TWO");
                        } else {
                            nodes[2].cnt++;
                        }
                        break;
                    case "THR":
                        if (nodes[3] == null) {
                            nodes[3] = new Node(1, "THR");
                        } else {
                            nodes[3].cnt++;
                        }
                        break;
                    case "FOR":
                        if (nodes[4] == null) {
                            nodes[4] = new Node(1, "FOR");
                        } else {
                            nodes[4].cnt++;
                        }
                        break;
                    case "FIV":
                        if (nodes[5] == null) {
                            nodes[5] = new Node(1, "FIV");
                        } else {
                            nodes[5].cnt++;
                        }
                        break;
                    case "SIX":
                        if (nodes[6] == null) {
                            nodes[6] = new Node(1, "SIX");
                        } else {
                            nodes[6].cnt++;
                        }
                        break;
                    case "SVN":
                        if (nodes[7] == null) {
                            nodes[7] = new Node(1, "SVN");
                        } else {
                            nodes[7].cnt++;
                        }
                        break;
                    case "EGT":
                        if (nodes[8] == null) {
                            nodes[8] = new Node(1, "EGT");
                        } else {
                            nodes[8].cnt++;
                        }
                        break;
                    case "NIN":
                        if (nodes[9] == null) {
                            nodes[9] = new Node(1, "NIN");
                        } else {
                            nodes[9].cnt++;
                        }
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(repeat(nodes[j]));
            }
            System.out.println("#" + (i + 1));
            System.out.println(sb);
            System.out.println();
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