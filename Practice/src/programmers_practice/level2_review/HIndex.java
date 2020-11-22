package programmers_practice.level2_review;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int h = citations.length-i;
            if(citations[i]>=h){
                return h;
            }
        }
        return answer;
    }
}
