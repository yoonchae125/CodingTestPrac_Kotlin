package programmers_practice.level2;

public class MatchTable {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            if(a%2 == 0){
                a = a/2;
            }else{
                a = (a+1)/2;
            }
            if(b%2 == 0){
                b = b/2;
            }else{
                b = (b+1)/2;
            }
            answer++;
        }

        return answer;
    }
}
