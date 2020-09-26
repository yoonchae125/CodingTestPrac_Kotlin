package programmers_practice.level2;

import java.util.ArrayList;

public class AppCuck {
    public int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<String> dic = new ArrayList<>();
        for(char c = 'A';c<='Z';c++){
            dic.add(c+"");
        }
        String str="";
        for(int i=0;i<msg.length()-1;i++){
            str += msg.charAt(i)+"";
            if(dic.contains(str+msg.charAt(i+1))){
//                str+=msg.charAt(i+1);
            }else{
                ans.add(dic.indexOf(str)+1);
                dic.add(str+msg.charAt(i+1));
                str = "";
            }
        }
        ans.add(dic.indexOf(str+msg.charAt(msg.length()-1))+1);

        int[] answer = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
