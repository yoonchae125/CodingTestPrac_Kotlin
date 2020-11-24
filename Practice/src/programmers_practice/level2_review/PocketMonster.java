package programmers_practice.level2_review;

import java.util.HashMap;

public class PocketMonster {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> kinds = new HashMap<>();
        for(int n:nums){
            if(!kinds.containsKey(n)){
                kinds.put(n, 0);
            }
        }
        if(kinds.size()>=nums.length/2){
            answer = nums.length/2;
        }else{
            answer = kinds.size();
        }
        return answer;
    }
}
