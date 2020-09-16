package programmers_practice.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Gualho {
    public String solution(String p) {
        String answer = "";

        if(p.isEmpty()){
            return p;
        }
        answer = go(p);
        return answer;
    }
    public String go(String p){
        int idx = 1;
        String u = "";
        String v = "";
        for(idx = 1;idx<p.length();idx+=2){
            u = p.substring(0,idx);
            if(isBalanced(u)){
//                System.out.println(idx);
                v = p.substring(idx);
                break;
            }
            idx++;
        }
//        System.out.println(u+","+v);
        if(isRight(u)){
            if(v.isEmpty()){
                return u;
            }
            return u+go(v);
        }else{
            String nu = u.substring(1,u.length()-1);
            if(v.isEmpty())
                return "()"+reverse(nu);
            return "("+go(v)+")"+reverse(nu);
        }
    }
    public boolean isBalanced(String str){
        boolean result = false;

        Queue<Character> queue = new LinkedList<>();
        queue.add(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(queue.isEmpty()){
                queue.add(str.charAt(i));
                continue;
            }
            if(str.charAt(i) == ')'){
                if(queue.peek() == '('){
                    queue.poll();
                }else{
                    queue.add(')');
                }
            }else{
                if(queue.peek() == ')'){
                    queue.poll();
                }else{
                    queue.add('(');
                }
            }
        }
        if(queue.isEmpty())
            result = true;
        return result;
    }
    boolean isRight(String str){
        boolean result = true;
        if(str.charAt(0)==')')
            return false;
        Queue<Character> queue = new LinkedList<>();
        queue.add(str.charAt(0));
        for(int i=1;i<str.length();i++){

            if(str.charAt(i) == '('){
                queue.add('(');
            }else{
                if(queue.isEmpty()){
                    result = false;
                    break;
                }
                queue.poll();
            }
        }
        return result;
    }
    String reverse(String str){
        if(str.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '(')
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }
}
