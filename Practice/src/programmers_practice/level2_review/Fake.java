package programmers_practice.level2_review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Fake {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] cloth:clothes){
            if(hm.containsKey(cloth[1])){
                hm.replace(cloth[1],hm.get(cloth[1])+1);
            }else{
                hm.put(cloth[1],1);
            }
        }

        Set<String> key = hm.keySet();
        Iterator<String> it = key.iterator();
        while(it.hasNext()){
            answer*=hm.get(it.next())+1;
        }
        return answer-1;
    }
}
