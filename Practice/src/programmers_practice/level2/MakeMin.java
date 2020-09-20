package programmers_practice.level2;

import java.util.Arrays;
import java.util.Collections;
public class MakeMin {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] BB = new Integer[B.length];
        for(int i=0;i<B.length;i++){
            BB[i] = B[i];
        }
        Arrays.sort(A);
        Arrays.sort(BB, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * BB[i];
        }

        return answer;
    }

}
