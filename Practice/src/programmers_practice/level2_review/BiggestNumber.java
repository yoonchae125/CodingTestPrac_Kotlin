package programmers_practice.level2_review;

import java.util.ArrayList;

public class BiggestNumber {
    public String solution(String number, int k) {
        String answer = "";
        ArrayList<Character> chars = new ArrayList<>();
        for(char c:number.toCharArray()){
            chars.add(c);
        }
        while(k-->0){
            int idx = 0;

            for(int i=1;i<chars.size();i++){
                if(chars.get(idx)>=chars.get(i)){
                    idx++;
                }else{
                    break;
                }
            }
            chars.remove(idx);
        }
        for(char c: chars){
            answer+=c;
        }
        return answer;
    }
}
