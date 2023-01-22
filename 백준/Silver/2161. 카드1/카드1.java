import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int j =0;
        StringBuilder sb= new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        while (j<n) {
            sb.append(list.get(0));
            sb.append(" ");
            j++;
            list.remove(0);
            if(list.isEmpty()) break;
            list.add(list.get(0));
            list.remove(0);
        }
        System.out.println(sb);
    }
}