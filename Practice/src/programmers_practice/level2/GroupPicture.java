package programmers_practice.level2;

import java.util.HashMap;

public class GroupPicture {

    public int solution(int n, String[] data) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
//        A, C, F, J, M, N, R, T
        hm.put("A", 0);
        hm.put("C", 1);
        hm.put("F", 2);
        hm.put("J", 3);
        hm.put("M", 4);
        hm.put("N", 5);
        hm.put("R", 6);
        hm.put("T", 7);
        int a[] = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        do {
            boolean flag = true;
            for (String d : data) {
                String x = d.charAt(0) + "";
                String y = d.charAt(2) + "";
                int realLen = len(hm.get(x), hm.get(y), a);
                int len = d.charAt(4)-'0';
                char opt = d.charAt(3);
//                System.out.println(realLen+","+len);
                switch (opt) {
                    case '=':
                        if(realLen!=len)
                            flag = false;
                        break;
                    case '>':
                        if(realLen<=len)
                            flag = false;
                        break;
                    case '<':
                        if(realLen>=len)
                            flag = false;
                        break;
                }
                if(!flag)
                    break;
            }
            if(flag){
                answer++;
            }
        } while (next_permutation(a));
        return answer;
    }

    public int len(int x, int y, int[] a) {
        int xx = 0;
        int yy = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                xx = i;
            }
            if (a[i] == y) {
                yy = i;
            }
        }
        return Math.abs(xx - yy)-1;
    }

    public static boolean next_permutation(int[] a) { // 순열
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
