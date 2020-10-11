package programmers_practice.level3;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        ArrayList<Integer> queue = new ArrayList<>();

        for(String op :operations){
            if(op.charAt(0) == 'I'){
                int n = Integer.parseInt(op.substring(2));
                queue.add(n);
                System.out.println(n);
                Collections.sort(queue);
            }else {
                if(queue.size() ==0)
                    continue;
                if(op.charAt(2) == '-'){
                    queue.remove(0);
                }else{
                    queue.remove(queue.size()-1);
                }
            }
        }

        if(queue.size()>0){
            answer[1] = queue.get(0);
            answer[0] = queue.get(queue.size()-1);
        }
        return answer;
    }
}
