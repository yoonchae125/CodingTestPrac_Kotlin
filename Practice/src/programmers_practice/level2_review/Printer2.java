package programmers_practice.level2_review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int p:priorities){
            list.add(p);
        }

        for(int i=0; i<priorities.length;i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int paper = queue.poll();
            Integer max = Collections.max(list);

            if(priorities[paper]>=max){
                list.remove(max);
                answer++;
                if(paper == location) {
                    break;
                }
            }else{
                queue.add(paper);
            }

        }
        return answer;
    }
}
