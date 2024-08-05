import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    static List<Integer>[] parties; 
    static boolean[] knowsTruth; 
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        knowsTruth = new boolean[N + 1];
        parent = new int[N + 1];
        parties = new List[M];

        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 초기에는 자신을 가리키도록 초기화
        }

        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowsTruth[person] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            parties[i].add(firstPerson);

            for (int j = 1; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
                union(firstPerson, person);
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (knowsTruth[find(person)]) { // 진실을 아는 집합에 속하면 거짓말 못함
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (knowsTruth[rootA]) parent[rootB] = rootA;
            else parent[rootA] = rootB;
        }
    }
}
