import java.util.*;

class Solution {
    public List<String> solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> set = new ArrayList<>();
        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                if (!set.contains(String.valueOf(order.charAt(i)))) {
                    set.add(String.valueOf(order.charAt(i)));
                }
            }
        }
        Collections.sort(set);

        Map<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            order = sortString(order);
            dfs(new boolean[order.length()], order, 0, course, map);
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() <= 1) {
                it.remove();
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int n=0;
            int courseLength = course[i];
            Iterator<Map.Entry<String, Integer>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Integer> entry = it2.next();
                if (courseLength == entry.getKey().length()) {
                    if (entry.getValue() > n) {
                        for (int j = 0; j < list.size(); j++) {
                            if(list.get(j).length()==courseLength) list.remove(j--);
                        }
                        list.add(entry.getKey());
                        n = entry.getValue();
                    }
                    else if (entry.getValue() == n) {
                        list.add(entry.getKey());
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void dfs(boolean[] visited, String order, int depth, int[] course,
                           Map<String, Integer> map) {
        if (depth == order.length()) {
            String menu = "";
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    menu += order.charAt(i);
                }
            }
            if (menu.length() < 2) {
                return;
            }
            for (int courseLength : course) {
                if (menu.length() == courseLength) {
                    if (!map.containsKey(menu)) {
                        map.put(menu, 1);
                    } else {
                        map.replace(menu, map.get(menu) + 1);
                    }
                }
            }
        } else {
            visited[depth] = true;
            dfs(visited, order, depth + 1, course, map);
            visited[depth] = false;
            dfs(visited, order, depth + 1, course, map);
        }
    }

    public static String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}