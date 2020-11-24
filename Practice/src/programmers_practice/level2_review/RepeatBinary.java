package programmers_practice.level2_review;

public class RepeatBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int times = 0;
        int zero = 0;

        while (!s.equals("1")) {
            times++;
            int len = s.length();
            s = s.replaceAll("0", "");
            int num = s.length();
            zero += len - num;
            String str = "";
            while(num>0){
                str = num%2+str;
                num/=2;
            }
            s = str;
        }
        answer[0] = times;
        answer[1] = zero;
        return answer;
    }
}
