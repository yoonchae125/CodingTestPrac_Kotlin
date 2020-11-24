package programmers_practice.level2_review;

import java.util.LinkedList;
import java.util.Queue;

public class RightGualho {
    boolean solution(String s) {
        boolean answer = true;

        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')'){
                if(queue.isEmpty()){
                    return false;
                }else{
                    int poll = queue.poll();
                    if(poll == ')'){
                        return false;
                    }
                }
            }else{
                queue.add(c);
            }
        }
        if(!queue.isEmpty()){
            return false;
        }
        return answer;
    }
}
