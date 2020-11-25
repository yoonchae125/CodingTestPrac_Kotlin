package programmers_practice.level2_review;

import java.util.Stack;

public class RemovePair {
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.add(c);
            }else{
                if (stack.peek() == c)
                    stack.pop();
                else
                    stack.add(c);
            }
        }
        if (stack.isEmpty()){
            answer = 1;
        }
        return answer;
    }
}
