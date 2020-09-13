package kakao_2021_blind_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Num1_1 {
    public String solution(String new_id) {
        String answer = "";
//    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        answer = new_id.toLowerCase();
        answer = remove(answer);
        answer = removeDot(answer);
        return answer;
    }
    String remove(String new_id){
//        -_.~!@#$%^&*()=+[{]}:?,<>
        String[] notAllowed = {"~","!","@","#","$","%","^","&",
                "\\*","\\(","\\)","=","\\+","\\[","\\{","\\]","\\}",":","\\?",",","<",">"};
        for(String s:notAllowed){
            new_id=new_id.replaceAll(s,"");
        }
        return new_id;
    }
    String removeDot(String new_id){
        boolean flag = false;
        int start = -1;
        int end = -1;
        Set len = new HashSet<String>();
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if(c=='.'){
                if(!flag){
                    flag = true;
                    start = i;
                }
            }else{
                if(flag){
                    flag = false;
                    end=i-1;
                    if((end-start)>1){
                        len.add(makeDot(end-start));
                    }
                }
            }
        }

        Iterator<String> it = len.iterator();
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
            new_id = new_id.replaceAll(str,".");
        }
        return new_id;
    }
    String makeDot(int len){
        StringBuffer dots = new StringBuffer();
        for(int i=0;i<len;i++){
            dots.append(".");
        }
        return dots.toString();
    }
}
