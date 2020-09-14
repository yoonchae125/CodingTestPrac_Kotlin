package programmers_practice.level2;

import java.util.*;

public class TruckBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<>();
        Map<Integer,Integer> left = new HashMap<Integer,Integer>();
        for (int i=0;i<truck_weights.length;i++) {
            trucks.add(i);
            left.put(i, bridge_length);
        }
        int time = 0;
        int bridge = 0;
        Queue<Integer> truckOnBridge = new LinkedList<>();

        while (!trucks.isEmpty()) {
            time++;
            int truck = trucks.peek();
            if (bridge + truck_weights[truck] > weight) {
                Iterator<Integer> it = truckOnBridge.iterator();
                while(it.hasNext()){
                    int key = it.next();
                    left.replace(key, left.get(key)-1);
                }
                int t = truckOnBridge.peek();
                if(left.get(t)==0){
                    truckOnBridge.poll();
                    bridge-=truck_weights[t];
                }
                continue;
            }
            trucks.poll();
            bridge+=truck_weights[truck];
            truckOnBridge.add(truck);
            Iterator<Integer> it = truckOnBridge.iterator();
            while(it.hasNext()){
                int key = it.next();
                left.replace(key, left.get(key)-1);
            }
            int t = truckOnBridge.peek();
            if(left.get(t)==0){
                truckOnBridge.poll();
                bridge-=truck_weights[t];
            }
        }
        while (!truckOnBridge.isEmpty()){
            time++;

            Iterator<Integer> it = truckOnBridge.iterator();
            while(it.hasNext()){
                int key = it.next();
                left.replace(key, left.get(key)-1);
            }
            int t = truckOnBridge.peek();
            if(left.get(t)==0){
                truckOnBridge.poll();
                bridge-=truck_weights[t];
            }
        }
        return time+1;
    }
}
