package programmers_practice.level2_review;

public class JadenCaseString {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String sub = c+"";
            if(c==' '){
                flag = true;
            }else{
                if(flag){
                    sub = sub.toUpperCase();
                }
                flag = false;
            }
            answer+=sub;
        }
        return answer;
    }
}
