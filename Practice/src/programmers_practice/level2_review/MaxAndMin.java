package programmers_practice.level2_review;

import java.util.Arrays;

public class MaxAndMin {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split(" ");
        int[] num = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            num[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(num);
        answer = num[0] + " " + num[num.length - 1];
        return answer;
    }
}
