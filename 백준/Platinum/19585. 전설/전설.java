import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 전설
// platinum 3
public class Main {

    static class Node {
        Node(){
            childNode = new Node[26];
            endOfWord = false;
        }
        // 자식노드
//        Map<Character, Node> childNode = new HashMap<>();
        Node[] childNode;
        boolean endOfWord;
    }

    static class Trie {

        Node rootNode = new Node();

        void insert(String s) {
            Node node = this.rootNode;
//            for (int i = 0; i < s.length(); i++) {
//                node = node.childNode.computeIfAbsent(s.charAt(i), key -> new Node());
//            }
            for (int i = 0; i < s.length(); i++) {
//                char ch = s.charAt(i);
//                if (!node.childNode.containsKey(ch)) {
//                    node.childNode.put(ch, new Node());
//                }
//                node = node.childNode.get(ch);

                char c = s.charAt(i);
                int index = c - 'a';
                if (node.childNode[index] == null)
                    node.childNode[index] = new Node();
                node = node.childNode[index];
            }
            node.endOfWord = true;
        }

        String search(String s) {
            Node node = this.rootNode;
            for (int i = 0; i < s.length(); i++) {
                if (node.endOfWord) {
                    if (names.contains(s.substring(i))) {
                        return "Yes";
                    }
                }
//                char c = s.charAt(i);
                char c = s.charAt(i);
                int index = c - 'a';
//                if(node.childNode.get(c)==null) return false;
                if(node.childNode[index]==null) break;
                node = node.childNode[index];
            }

            return "No";
        }
    }

    static Trie colors;
    static Set<String> names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        colors = new Trie();
        names = new HashSet<>();

        for (int i = 0; i < c; i++) {
            String color = br.readLine();
            colors.insert(color);
        }
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names.add(name);
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String team = br.readLine();
            sb.append(colors.search(team)).append("\n");
        }

        System.out.println(sb);
    }
}
