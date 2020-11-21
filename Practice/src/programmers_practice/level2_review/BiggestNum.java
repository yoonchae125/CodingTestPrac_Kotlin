package programmers_practice.level2_review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
    public String solution(int[] numbers) {
        String answer = "";

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();

                return Integer.compare(Integer.parseInt(s2+s1),Integer.parseInt(s1+s2));
            }
        });
        for (int n : nums) {
            answer += n;
        }

        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
}
