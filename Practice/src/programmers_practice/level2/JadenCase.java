package programmers_practice.level2;

public class JadenCase {
    public String solution(String s) {
        String answer = "";

        s=s.toLowerCase();
        char prev=' ';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)){
                if(prev==' '){
                    answer+=Character.toUpperCase(c);
                    prev = c;
                    continue;
                }
                answer+=c;
                prev = c;
            }else{
                answer+=c;
                prev = c;
            }
        }
        return answer;
    }
}
