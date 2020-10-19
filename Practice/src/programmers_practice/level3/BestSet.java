package programmers_practice.level3;

import java.util.Arrays;

public class BestSet {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        int[] answer = new int[n];

        for(int i=0;i<n;i++){
            answer[i] = s/n;
        }
        for(int i=0;i<s%n;i++){
            answer[i]+=1;
        }
        Arrays.sort(answer);
        return answer;
    }

}
