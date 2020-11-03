package programmers_practice.level2;

public class Year2016 {
    public String solution(int a, int b) {
        String answer;

        int dayOfMonth[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        String day[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};

        int days = 0;
        for(int i=1;i<a;i++){
            days+=dayOfMonth[i];
        }
        days+=b;
        answer = day[days%7];

        return answer;
    }
}
