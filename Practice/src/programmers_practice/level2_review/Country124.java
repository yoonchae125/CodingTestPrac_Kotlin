package programmers_practice.level2_review;

public class Country124 {
    public String solution(int n) {
        String answer = "";
        String num[] = {"4", "1", "2",};
        while(n>0){
            int r = n%3;
            answer = num[r]+answer;
            n = n/3;
            if(r==0)
                n-=1;
        }
        return answer;
    }
}
