package BaekJun;

import java.io.*;

public class Num9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());;
            long[] d = new long[n+1];
            d[0] = 0;
            d[1] = 1;
            if(n>=2){
                d[2] = 1;
            }
            for(int i=3;i<=n;i++){
                d[i] = d[i-3] + d[i-2];
            }
            bw.write(d[n]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
