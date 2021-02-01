package programmers_practice.level1;

import java.util.Arrays;
import java.util.HashSet;

public class SelectAndAdd {
    static HashSet<Integer> set = new HashSet<>();
    public static int[] solution(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] ans = new Integer[set.size()];
        int[] answer = new int[set.size()];
        set.toArray(ans);
        Arrays.sort(ans);
        for(int i=0;i<ans.length;i++){
            answer[i] = ans[i];
        }
        return answer;
    }
    public static void main(String[] args){
        int[] ans = solution(new int[]{2, 1, 3, 4, 1});
        for(int a: ans){
            System.out.print(a+" ");
        }
    }
}
