package programmers_practice.level2_review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SavingBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int i=0;
        for(int j = people.length-1;i<=j;j--){
            answer++;
            if(people[i]+people[j]>limit){ }
            else{
                i++;
            }
        }

        return answer;
    }
}
