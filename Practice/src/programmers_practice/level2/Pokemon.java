package programmers_practice.level2;

import java.util.HashMap;

public class Pokemon {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> kinds = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            kinds.put(nums[i],1);
        }
        answer = nums.length/2;
        if(kinds.size()<nums.length/2){
            answer = kinds.size();
        }
        return answer;
    }
}
