package programmers_practice.level2_review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DevelopFeature {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList();

        Queue<Integer> pQueue = new LinkedList<>();
        Queue<Integer> sQueue = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            pQueue.add(progresses[i]);
            sQueue.add(speeds[i]);
        }
        int count = 0;
        int time = 0;
        while (!pQueue.isEmpty() && !sQueue.isEmpty()){
            int p = pQueue.peek();
            int s = sQueue.peek();
            if((p+time*s)>=100){
                pQueue.poll();
                sQueue.poll();
                count++;
            }else{
                if(count>0){
                    answerList.add(count);
                    count = 0;
                }
                int left = 100 - (p+time*s);
                time+=left/s + left%s>0?1:0;
            }
        }
        if(count>0){
            answerList.add(count);
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
