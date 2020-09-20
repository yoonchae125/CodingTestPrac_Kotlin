package programmers_practice.level2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        for(int i=3;i<total;i++){
            if(total%i!=0)
                continue;
            int a = total/i;
            int b = i;
            if((a-2)*(b-2)==yellow){
                answer[0] = a;
                answer[1] = b;
                break;
            }
        }
        return answer;
    }
}
