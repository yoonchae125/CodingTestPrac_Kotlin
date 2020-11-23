package programmers_practice.level2_review;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = find(numbers, target, 0, 0);
        return answer;
    }
    int find(int[] numbers, int target, int now, int idx){
        if(idx == numbers.length){
            if(target == now)
                return 1;
            else
                return 0;
        }
        return find(numbers, target, now+numbers[idx], idx+1)+find(numbers, target, now-numbers[idx], idx+1);
    }
}
