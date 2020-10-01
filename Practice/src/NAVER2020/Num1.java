package NAVER2020;

public class Num1 {
    public String solution(String m, String k){
        String answer = "";

        int idx = 0;
        for(int i=0;i<k.length();i++){
            char c = k.charAt(i);
            while(idx<m.length()){
                if(m.charAt(idx) == c){
                    m =m.substring(0,idx)+m.substring(idx+1);
                    break;
                }else {
                    idx++;
                }
            }
        }

        return m;
    }
}
