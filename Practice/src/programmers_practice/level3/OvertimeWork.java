package programmers_practice.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeWork {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int w:works){
            pq.offer(w);
        }
        while(n-->0){
            int max = pq.poll();
            if(max==0)
                return 0;
            pq.offer(max-1);
        }
        while(!pq.isEmpty()){
            int w = pq.poll();
            answer+=w*w;
        }
        return answer;
    }
}
