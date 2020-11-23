package programmers_practice.level2_review;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];


        // 2*a + 2*b -4 = brown
        // (a-2) * (b-2) = yellow
        for(int b = 3; b<=brown/2;b++){

            if(yellow%(b-2)!=0) continue;
            int a = yellow/(b-2)+2;

            if(brown == 2*a + 2*b -4){
                answer[0] = a;
                answer[1] = b;
                break;
            }
        }

        return answer;
    }
}
