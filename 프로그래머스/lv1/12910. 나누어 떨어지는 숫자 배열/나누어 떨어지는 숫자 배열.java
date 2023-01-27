import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution {

    public List<Integer> solution(int[] a , int b){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i]%b==0){
                list.add(a[i]);
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        Collections.sort(list);
        return list;
    }
}