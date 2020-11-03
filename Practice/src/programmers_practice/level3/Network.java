package programmers_practice.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean check[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(check[i]) {
//                System.out.println("pass"+i);
                continue;
            }
//            System.out.println(i);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            check[i] = true;
            answer++;
            while (!queue.isEmpty()){
                int a = queue.poll();
//                System.out.println("a"+a);

                for(int d = 0;d<n;d++){
                    if(check[d])
                        continue;
                    if(computers[a][d]==1){
                        queue.add(d);
                        check[d] = true;
                    }
                }
            }
        }

        return answer;
    }
}
