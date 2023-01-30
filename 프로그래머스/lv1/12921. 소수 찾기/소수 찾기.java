class Solution {
     static boolean [] list;
    static void prime_Num (int num)
    {
        for (int i = 2; i <= num; i++) {
            if (!list[i]) {
                for (int j = 2*i; j <= num; j+=i) {
                    list[j] = true;
                }
            }
        }
    }

    public static int solution(int n) {
        int answer = 0;
        list = new boolean[n+1];
        list[0] = true;
        list[1] = true;
        prime_Num(n);
        for (int i = 0; i <=n; i++) {
            if(!list[i])
            {
                answer++;
            }
        }
//        System.out.println("Arrays.toString(list) = " + Arrays.toString(list));
        return answer;
    }
}