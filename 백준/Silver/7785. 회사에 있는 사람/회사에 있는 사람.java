
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> stringMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stringMap.put(st.nextToken(), st.nextToken());
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> e : stringMap.entrySet()) {
            if (e.getValue().equals("enter")) {
                list.add(e.getKey());
            }
        }
        list.sort(Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}