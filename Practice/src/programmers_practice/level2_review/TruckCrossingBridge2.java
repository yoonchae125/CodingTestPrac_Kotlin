package programmers_practice.level2_review;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> onBridge = new LinkedList<>();

        for(int i =0; i<bridge_length; i++){
            onBridge.add(0);
        }

        int idx = 0;
        while (!onBridge.isEmpty() && idx<truck_weights.length) {
            onBridge.poll();
            answer++;
            if (getWeight(onBridge) + truck_weights[idx] > weight) {
                onBridge.add(0);
            } else {
                onBridge.add(truck_weights[idx++]);
            }
        }
        answer+=onBridge.size();
        return answer;
    }
    int getWeight(Queue<Integer> queue){
        int weight = 0;

        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            weight+=it.next();
        }

        return weight;
    }
}
