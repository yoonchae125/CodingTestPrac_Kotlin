package programmers_practice.level2;

import java.util.*;

public class Hotter {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleList = new PriorityQueue();
        for(int s:scoville){
            scovilleList.add(s);
        }

        while(true){
            if(scovilleList.peek()>=K){
                break;
            }
            if(scovilleList.size()==1){
                answer = -1;
                break;
            }
//            System.out.println(scovilleList.get(0)+","+scovilleList.get(1));

            int newScoville = scovilleList.poll()+scovilleList.poll()*2;
            answer++;
            scovilleList.add(newScoville);
        }
        return answer;
    }
}
