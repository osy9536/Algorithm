import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
class Solution {
    public static int solution(String dartResult) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                if (dartResult.charAt(i) == '1') {
                    if (dartResult.charAt(i + 1) == '0') {
                        if (dartResult.charAt(i+2) == 'S') {
                            list.add(String.valueOf(10));
                        } else if (dartResult.charAt(i+2) == 'D') {
                            list.add(String.valueOf(100));
                        } else if (dartResult.charAt(i+2) == 'T') {
                            list.add(String.valueOf(1000));
                        }
                        i++;
                    } else list.add(String.valueOf(1));
                }
                else if (dartResult.charAt(i+1) == 'S') {
                    list.add(String.valueOf(dartResult.charAt(i)));
                } else if (dartResult.charAt(i+1) == 'D') {
                    list.add(String.valueOf((dartResult.charAt(i)-48) * (dartResult.charAt(i)-48)));
                } else if (dartResult.charAt(i+1) == 'T') {
                    list.add(String.valueOf((dartResult.charAt(i)-48)*(dartResult.charAt(i)-48)*(dartResult.charAt(i)-48)));
                }
            }
            else if(dartResult.charAt(i)=='*'||dartResult.charAt(i)=='#') list.add(String.valueOf(dartResult.charAt(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), "#")) {
                list.set(i-1, "-" + list.get(i - 1));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), "*")) {

                int b = Integer.parseInt(list.get(i - 1));
                if (i >= 2) {
                    list.set(i - 1, String.valueOf(b * 2));
                    if (Objects.equals(list.get(i - 2), "*")||Objects.equals(list.get(i - 2), "#")) {
                        int a = Integer.parseInt(list.get(i - 3));
                        list.set(i - 3, String.valueOf(a * 2));
                    } else {
                        int a = Integer.parseInt(list.get(i - 2));
                        list.set(i - 2, String.valueOf( a * 2));
                    }
                }
                else list.set(0, String.valueOf(b * 2));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), "#") && !Objects.equals(list.get(i), "*")) {
                answer += Integer.parseInt(list.get(i));
            }
        }// 1000, 1000, *, 1000, 1000, *
        return answer;
    }
}