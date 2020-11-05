package programmers_practice.level3;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;

        LinkedList<Task> waiting = new LinkedList<>();
        java.util.PriorityQueue<Task> priorityQueue = new java.util.PriorityQueue<>((o1, o2) -> o1.length-o2.length);

        for(int i=0;i<jobs.length;i++){
            waiting.add(new Task(jobs[i][0],jobs[i][1]));
        }

        Collections.sort(waiting, (o1, o2) -> o1.inTime-o2.inTime);
        int cnt = 0;
        int time = 0;
        while(cnt<jobs.length){
            while(!waiting.isEmpty() && waiting.peek().inTime<=time){
                priorityQueue.add(waiting.poll());
            }
            if(priorityQueue.isEmpty()){
                time++;
            }else{
                Task t = priorityQueue.poll();
                time += t.length;
                answer+= time - t.inTime;
                cnt++;
            }
        }

        return answer/cnt;
    }
    class Task {
        int inTime;
        int length;
        Task(int inTime, int length){
            this.inTime = inTime;
            this.length = length;
        }
    }
}
