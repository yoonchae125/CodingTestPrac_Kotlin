package programmers_practice.level1;

public class 콜라츠 {
    public static int solution(int num) {
        int answer = 0;
        long number = num;
        while(true){
            if(number==1)
                break;
            if(answer==500){
                answer = -1;
                break;
            }
            answer++;
            if(number%2==0){
                number=number/2;
            }else{
                number = number*3+1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int ans = solution(626331);
        System.out.println(ans);
    }
}
