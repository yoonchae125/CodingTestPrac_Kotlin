package programmers_practice.level2_review;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Hotter {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        for(int s:scoville){
            sc.add(s);
        }
        while(!check(sc, K)){
            if(sc.size()<2){
                return -1;
            }
            int a = sc.poll();
            int b = sc.poll();
            sc.add(a+b*2);
            answer++;
        }
        return answer;
    }
    boolean check(PriorityQueue<Integer> q, int K){
        Iterator<Integer> it = q.iterator();
        while(it.hasNext()){
            int next = it.next();
            if(next>=K)
                continue;
            return false;
        }
        return true;
    }
}
