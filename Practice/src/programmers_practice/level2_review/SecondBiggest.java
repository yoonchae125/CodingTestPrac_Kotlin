package programmers_practice.level2_review;

public class SecondBiggest {
    public int solution(int n) {
        for(int i = n+1; ; i++){
            if(Integer.bitCount(i) == Integer.bitCount(n)){
                return i;
            }
        }
    }
}
