package programmers_practice.level2_review;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length;i++){
            q.add(0);
        }
        int idx=0;
        while(!q.isEmpty()){
            if(idx>=truck_weights.length) {
                answer+=q.size();
                break;
            }
            q.poll();
            answer++;
            if(getWeight(q)+truck_weights[idx]>weight){
                q.add(0);
            }else{
                q.add(truck_weights[idx++]);
            }
        }

        return answer;
    }
    int getWeight(Queue<Integer> bridge){
        int w = 0;

        Iterator<Integer> it = bridge.iterator();

        while(it.hasNext()){
            w+=it.next();
        }

        return w;
    }
}
