import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int buildingCount = Integer.parseInt(reader.readLine());
        int[] heights = new int[buildingCount + 1];
        int[] visibleCount = new int[buildingCount + 1];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 1; i <= buildingCount; i++) {
            heights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int maxVisible = 0;

        // 각 건물에 대해 보이는 건물 수 계산
        for (int i = 1; i <= buildingCount; i++) {
            for (int j = i + 1; j <= buildingCount; j++) {
                double distance = j - i;
                double heightDifference = heights[j] - heights[i];
                double slope = heightDifference / distance;  // 기울기 계산

                boolean isVisible = true;

                // 두 건물 사이의 다른 건물이 시야를 가리는지 확인
                for (int k = i + 1; k < j; k++) {
                    double expectedHeight = slope * (k - i) + heights[i];
                    if (expectedHeight <= heights[k]) {
                        isVisible = false;
                        break;
                    }
                }

                if (isVisible) {
                    visibleCount[i]++;
                    visibleCount[j]++;
                }
            }

            if (visibleCount[i] > maxVisible) {
                maxVisible = visibleCount[i];
            }
        }

        System.out.println(maxVisible);
    }
}