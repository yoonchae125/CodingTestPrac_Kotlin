package programmers_practice.level2;

public class ExpressionOfNum {
    public int solution(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++){
            int sum = i;
            if(sum>n){
                break;
            }
            if(sum == n) {
                answer++;
                break;
            }
            for(int k=i+1;k<=n;k++){
                sum+=k;
                if(sum==n){
                    answer++;
                    break;
                }
                if(sum>n){
                    break;
                }
            }
        }

        return answer;
    }
}
