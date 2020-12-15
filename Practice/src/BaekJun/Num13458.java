package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }
        String[] s2 = br.readLine().split(" ");
        int B = Integer.parseInt(s2[0]);
        int C = Integer.parseInt(s2[1]);

        int answer = N;
        for (int i = 0; i < N; i++) {
            if (A[i] <= B) {
                continue;
            } else {
                answer += (A[i] - B) / C;
                if ((A[i] - B) % C != 0) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
