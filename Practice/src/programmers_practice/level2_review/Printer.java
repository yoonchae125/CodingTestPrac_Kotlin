package programmers_practice.level2_review;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Paper> printer = new LinkedList<>();
        for(int i =0;i<priorities.length;i++){
            printer.add(new Paper(i, priorities[i]));
        }

        while(!printer.isEmpty()){
            Paper paper = printer.poll();
            Iterator<Paper> it = printer.iterator();
            boolean flag = false;
            while(it.hasNext()){
                Paper pInp = it.next();
                if(paper.priority<pInp.priority){
                    printer.add(paper);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer++;
                if(paper.id == location){
                    break;
                }
            }
        }
        return answer;
    }
    class Paper{
        int id;
        int priority;
        Paper(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
}
