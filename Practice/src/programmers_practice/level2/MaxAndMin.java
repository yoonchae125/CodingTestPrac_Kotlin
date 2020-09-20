package programmers_practice.level2;

import java.util.Arrays;

public class MaxAndMin {
    public String solution(String s) {
        String answer = "";

        String[] nums = s.split(" ");
        int[] num = new int[nums.length];
        for(int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(num);
        answer = num[0]+" "+num[num.length-1];

        return answer;
    }
}
