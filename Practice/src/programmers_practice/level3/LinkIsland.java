package programmers_practice.level3;

import java.util.Arrays;
import java.util.Comparator;

public class LinkIsland {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Edge edges[] = new Edge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        int parent[] = new int[n]; // Uinon - Find 알고리즘에서 사용 한 부모 정점 저장 배열
        for(int i=0;i<parent.length;i++) { // 최초 정점 상태
            parent[i] = i;
        }

        for(int i=0;i<edges.length;i++) {
            //객체에 저장되어있는 두 정점에서 사이클이 있는지 확인
            //-1을 해주는 이유는 전달되는 parent 배열이 7의 크기를 가지므로,
            // 1씩 밀려서 인덱스를 사용 ex) 1번 정점은 0번 인덱스
            // 사이클이 발생하지 않는다면,
            if(!findParent(parent,edges[i].i,edges[i].j)) {
                answer+=edges[i].cost; // 총 소모비용
                unionParent(parent,edges[i].i,edges[i].j);
                // 두 정점을 연결
            }
        }

        return answer;
    }
    public static int getParent(int[] arr,int x) {
        if(arr[x] == x) return x; // 자기 자신이 부모일 경우
        return arr[x] = getParent(arr,arr[x]);
    }

    public void unionParent(int[] arr,int a,int b) {
        a = getParent(arr,a);
        b = getParent(arr,b);

        if(a<b) arr[b] = a;
        else arr[a] = b;
    }

    public boolean findParent(int[] arr,int a, int b) {
        a = getParent(arr,a);
        b = getParent(arr,b);

        if(a==b) return true;
        else return false;
    }
    class Edge {
        int i, j, cost;

        Edge(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
}
