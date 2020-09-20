package programmers_practice.level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> cloth = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            String key = clothes[i][1];
            if(cloth.get(key)!=null){
                cloth.replace(key,cloth.get(key)+1);
            }else{
                cloth.put(key, 1);
            }
        }
        if (cloth.size()==0){
            return 0;
        }else if(cloth.size()==1){
            Set<String>  keys = cloth.keySet();
            Iterator<String> it = keys.iterator();
            while(it.hasNext()) {
                String key = it.next();
                answer = cloth.get(key);
            }
            return answer;
        }else{
            Set<String>  keys = cloth.keySet();
            Iterator<String> it = keys.iterator();
            while(it.hasNext()){
                String key = it.next();
//                System.out.println(cloth.get(key));
                answer*=cloth.get(key)+1;
            }
            answer--;
        }

        return answer;
    }
}
