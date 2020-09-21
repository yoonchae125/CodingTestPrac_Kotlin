package programmers_practice.level2;

public class LCM {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1;i<arr.length;i++){
            answer = answer*arr[i] / gcd(answer, arr[i]);
        }

        return answer;
    }
    public static int gcd(int x, int y) { // 최대공약
        // 최소공배수 : (a*b)/gcd
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}

