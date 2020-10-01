package programmers_practice.level3;

public class ExpressWithN {
    int answer = -1;
    public int solution(int N, int number) {
        cal(N,number,0,0);
        return answer;
    }
    public void cal(int n, int number,int now, int count){
        if(count>8){
            return;
        }
        if(now == number){
            if(answer==-1 ||answer>count)
                answer = count;
            return;
        }
        int nn= n;
        for(int i=1;i<9-count;i++){
            cal(n, number, now+nn, count+i);
            cal(n, number, now-nn, count+i);
            cal(n, number, now/nn, count+i);
            cal(n, number, now*nn, count+i);
            nn=nn*10+n;
        }
    }
}
