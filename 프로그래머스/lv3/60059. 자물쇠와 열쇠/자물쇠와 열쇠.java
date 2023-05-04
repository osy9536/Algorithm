class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] map = new int[key.length * 2 + lock.length - 2][key.length * 2 + lock.length - 2];
        int[][] tempMap = map;
        int cnt = 0;
        for (int[] i : lock) {
            for (int j : i) {
                if (j == 0) {
                    cnt++;
                }
            }
        }

        for (int i = key.length - 1; i < key.length + lock.length - 1; i++) {
            for (int j = key.length - 1; j < key.length + lock.length - 1; j++) {
                map[i][j] = lock[i - (key.length - 1)][j - (key.length - 1)];
            }
        }

        if (cnt == 0) return true;
        int n = cnt;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < map.length - key.length + 1; i++) {
                for (int j = 0; j < map.length - key.length + 1; j++) {
                    for (int l = 0; l < key.length; l++) {
                        for (int m = 0; m < key.length; m++) {
                            map[i + l][j + m] += key[l][m];
                        }
                    }

                    boolean flag = true;
                    for (int l = key.length - 1; l < key.length + lock.length - 1; l++) {
                        for (int m = key.length - 1; m < key.length + lock.length - 1; m++) {
                            if (map[l][m] != 1) {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }

                    if(flag) return true;
                    for(int l=0; l<key.length; l++){
                        for(int m=0; m<key.length; m++){
                            map[i+l][j+m] -= key[l][m];
                        }
                    }
                }
            }
            rotate(key);
        }

        return answer;
    }

    private static void rotate(int[][] key) {
        int[][] temp = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                temp[i][j] = key[key.length - j - 1][i];
            }
        }
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
}