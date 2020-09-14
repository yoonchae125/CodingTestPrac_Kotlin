package programmers_practice.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FeatureDeployment {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
//        [93, 30, 55]	[1, 30, 5]	[2, 1]
        Queue<Integer> progress = new LinkedList<Integer>();
        Queue<Integer> did = new LinkedList<Integer>();
        int day=1;
        for(int i = 0; i<progresses.length; i++){
            progress.add(progresses[i]);
            did.add(speeds[i]);
        }
        while(!progress.isEmpty()){
            int count = 0;
            while(!progress.isEmpty()){
                int p = progress.peek();
                int d = did.peek()*day;

                if(p+d>=100){
                    progress.poll();
                    did.poll();
                    count++;
                }else{
                    if(count>0){
                        ans.add(count);
                    }
                    break;
                }
            }
            day++;
            if(progress.isEmpty()){
                ans.add(count);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
