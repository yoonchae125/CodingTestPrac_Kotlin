package programmers_practice.level2;

public class MakeDecimal {
    public int solution(int[] nums) {
        int answer = 0;

        answer += search(nums, 0, 0,0);

        return answer;
    }

    int search(int[] nums, int idx, int now, int count) {
        if(count>3)
            return 0;
        if (idx == nums.length) {
            if(count!=3)
                return 0;
            if (is_prime(now)) {
//                System.out.println(now);
                return 1;
            }
            else return 0;
        }
        return search(nums, idx + 1, now + nums[idx], count+1) + search(nums, idx + 1, now, count);
    }

    public static boolean is_prime(int x) {
        if (x <= 1) {
            return false;
        } else if (x == 2) {
            return true;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
