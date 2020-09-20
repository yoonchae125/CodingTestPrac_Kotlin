package programmers_practice.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RightGualho {
    boolean solution(String s) {
        boolean answer = true;

        if(s.charAt(0)==')')
            return false;
        Queue<Character> queue = new LinkedList<>();
        queue.add(s.charAt(0));
        for(int i=1;i<s.length();i++){

            if(s.charAt(i) == '('){
                queue.add('(');
            }else{
                if(queue.isEmpty()){
                    answer = false;
                    break;
                }
                queue.poll();
            }
        }
        if(!queue.isEmpty())
            answer=false;
        return answer;
    }
}
