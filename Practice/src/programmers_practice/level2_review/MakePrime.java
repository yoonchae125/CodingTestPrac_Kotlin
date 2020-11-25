package programmers_practice.level2_review;

public class MakePrime {

    public int solution(int[] nums) {
        return go(nums, 0, 0, 0);
    }

    int go(int[] nums, int count, int now, int idx) {
        if(count>3){
            return 0;
        }
        if (idx == nums.length) {
            if (count == 3 && isPrime(now)) {
                return 1;
            }
            return 0;
        }
        return go(nums, count, now, idx+1) + go(nums, count+1, now+nums[idx], idx+1);
    }

    boolean isPrime(int x) {
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
