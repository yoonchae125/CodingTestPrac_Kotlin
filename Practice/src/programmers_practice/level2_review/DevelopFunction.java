package programmers_practice.level2_review;

import java.util.*;

public class DevelopFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;

        int idx = 0;
        int day = 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (idx < n) {
            if(progresses[idx]+speeds[idx]*day >= 100){
                if(hm.get(day)!=null){

                    hm.replace(day, hm.get(day)+1);
                }else{

                    hm.put(day, 1);
                }
                idx++;
            }else {
                day++;
            }
        }
        int[] answer = new int[hm.size()];
        Set<Integer> keys = hm.keySet();
        Object[] keyArray = keys.toArray();
        Arrays.sort(keyArray);

        for(int i=0; i<keyArray.length;i++) {
            int key = (int) keyArray[i];
            answer[i] = hm.get(key);
        }
        return answer;
    }
}
