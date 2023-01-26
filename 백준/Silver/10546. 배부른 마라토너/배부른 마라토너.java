import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int inputSize = 2*N-1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < inputSize; i++) {
            String s = br.readLine();
            if(map.containsKey(s)) {
                map.remove(s);
            }
            else {
                map.put(s, 1);
            }
        }
        String s = map.toString();
        s = s.split("=")[0];
        System.out.println(s.substring(1, s.length()));
    }
}