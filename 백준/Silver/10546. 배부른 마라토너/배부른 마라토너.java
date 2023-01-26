import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 1; i < n; i++) {
            String s = br.readLine();
            if (map.get(s) == 1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s)-1);
            }
        }
        for (String s : map.keySet()) {
            System.out.print(s);
        }
    }
}