package NAVER2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num3 {
    public int solution(int n, int[][] edges){
        int answer = 0;

        int nodes[] = new int[n];
        ArrayList<Integer>[] networks = new ArrayList[edges[edges.length-1][0]+1];
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int e = edges[i][1];

            if(networks[s] == null) {
                networks[s] = new ArrayList();
            }
            ArrayList array = networks[s];
            array.add(e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        nodes[0] = 1;
        while (!q.isEmpty()){
            int node = q.poll();
            if(node>=networks.length)continue;

            if(networks[node]==null) continue;
            for(int i=0;i<networks[node].size();i++){
                q.add(networks[node].get(i));
                nodes[networks[node].get(i)] = 1;
            }
        }
//        for(int i = 0;i<networks.length;i++){
//            if(networks[i] == null)
//                continue;
//            for(int j=0; j<networks[i].size();j++){
//                System.out.println(i+","+networks[i].get(j));
//            }
//        }
        int a = nodes[networks[0].get(1)];
        for(int i=0;i<n;i++){
            System.out.println(nodes[i]);
            if(nodes[i]==1)
                answer++;
        }
//        ArrayList<Integer> l1 = new ArrayList<>();
//        ArrayList<Integer> l2 = new ArrayList<>();
//        l1.addAll(l2);
        return answer;
    }
}
