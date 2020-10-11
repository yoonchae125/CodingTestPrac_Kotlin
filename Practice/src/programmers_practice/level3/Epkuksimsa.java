package programmers_practice.level3;

import java.util.Arrays;

public class Epkuksimsa {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        answer = binarySearch(n, times);

        return answer;
    }
    long binarySearch(int n, int[] times){
        long ans = Long.MAX_VALUE;

        int left = times[0];
        int right = times[times.length-1] * n;

        while(left <= right){
            int mid = ( left + right ) / 2;
            int count = 0;
            for(int i=0;i<times.length;i++){
                count += mid/times[i];
            }
            if(count >= n){
                ans = ans > mid ? mid : ans;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
