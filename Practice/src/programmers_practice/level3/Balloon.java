package programmers_practice.level3;

import java.util.ArrayList;
import java.util.HashSet;

public class Balloon {
    HashSet set = new HashSet();
    public int solution(int[] a) {
        int answer = 0;

        ArrayList balloons = new ArrayList();

        for(int i=0;i<a.length;i++){
            balloons.add(a[i]);
        }

        search(balloons,false);
        answer = set.size();

        return answer;
    }
    public void search(ArrayList<Integer> balloons, boolean did){
        if(balloons.size()==1){
            set.add(balloons.get(0));
            return;
        }
        if(did){
            for(int i=0;i<balloons.size()-1;i++){
                int removed;
                int idx;
                if(balloons.get(i)>balloons.get(i+1)){
                    removed = balloons.get(i);
                    idx = i;
                    balloons.remove(i);
                }else{
                    removed = balloons.get(i+1);
                    idx = i+1;
                    balloons.remove(i+1);
                }
                search(balloons,true);
                balloons.add(idx, removed);
            }
        }else{
            for(int i=0;i<balloons.size()-1;i++){
                int removed;
                int idx;
                if(balloons.get(i)>balloons.get(i+1)){
                    removed = balloons.get(i);
                    idx = i;
                    balloons.remove(i);
                }else{
                    removed = balloons.get(i+1);
                    idx = i+1;
                    balloons.remove(i+1);
                }
                search(balloons,false);
                balloons.add(idx, removed);
            }
            for(int i=0;i<balloons.size()-1;i++){
                int removed;
                int idx;
                if(balloons.get(i)<balloons.get(i+1)){
                    removed = balloons.get(i);
                    idx = i;
                    balloons.remove(i);
                }else{
                    removed = balloons.get(i+1);
                    idx = i+1;
                    balloons.remove(i+1);
                }
                search(balloons,true);
                balloons.add(idx, removed);
            }
        }
    }
}
