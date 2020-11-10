import java.util.Arrays;
import java.util.Comparator;

public class Zip {
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

    int[][] clockwiseRotatedBox(int[][] box) { // 배열 회전
        int n = box.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = box[n - j - 1][i];
            }
        }
        return rotated;
    }

    int[][] counterClockwiseRotatedBox(int[][] box) {
        int n = box.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = box[j][n - 1 - j];
            }
        }
        return rotated;
    }

    public static int gcd(int x, int y) { // 최대공약
        // 최소공배수 : (a*b)/gcd
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static boolean is_prime(int x) { // 소수?
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

    public static final int INF = 1000000000;

    public static void FloyWarshall(int num, int size, int[][] cost) {
        int costs[][] = new int[num + 1][num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (i == j)
                    costs[i][j] = 0;
                else
                    costs[i][j] = INF;
            }
        }
        for (int i = 0; i < size; i++) {
            int s = cost[i][0];
            int e = cost[i][1];
            int c = cost[i][2];
            costs[s][e] = Math.min(costs[s][e], c);
        }

        for (int mid = 1; mid <= num; mid++) {
            for (int i = 1; i <= num; i++) {
                if (i == mid) continue;
                for (int j = 1; j <= num; j++) {
                    if (j == mid) continue;
                    int newCost = costs[i][mid] + costs[mid][j];
                    costs[i][j] = Math.min(costs[i][j], newCost);
                }
            }
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (costs[i][j] == INF)
                    System.out.print("0 ");
                else
                    System.out.print(costs[i][j] + " ");

            }
            System.out.println();
        }

    }

    static class KruskalMST {
        public static int solution(int n, int[][] costs) {
            int answer = 0;

            Edge[] edges = new Edge[costs.length];

            for (int i = 0; i < costs.length; i++) {
                int[] cost = costs[i];
                edges[i] = new Edge(cost[0], cost[1], cost[2]);
            }

            Arrays.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.cost - o2.cost;
                }
            });

            int parents[] = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < edges.length; i++) {
                if (!cycle(parents, edges[i].s, edges[i].e)) {
                    answer += edges[i].cost; // 총 소모비용
                    union(parents, edges[i].s, edges[i].e);
                    // 두 정점을 연결
                }
            }

            return answer;
        }

        static int getParent(int arr[], int i) {
            if (arr[i] == i) {
                return i;
            }
            return arr[i] = getParent(arr, arr[i]);
        }

        static void union(int arr[], int a, int b) {
            int pa = getParent(arr, a);
            int pb = getParent(arr, b);
            if (pa < pb)
                arr[pb] = pa;
            else
                arr[pa] = pb;

        }

        static boolean cycle(int arr[], int a, int b) {
            int pa = getParent(arr, a);
            int pb = getParent(arr, b);

            if (pa == pb)
                return true;
            else
                return false;
        }

        static class Edge {
            int s, e, cost;

            Edge(int s, int e, int cost) {
                this.s = s;
                this.e = e;
                this.cost = cost;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] a = {{1, 2}, {4, 3}};
//        Zip zip = new Zip();
//        int[][] b = zip.clockwiseRotatedBox(a);
//        for (int i = 0; i < b.length; i++) {
//            for (int j = 0; j < b[i].length; j++) {
//                System.out.print(b[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        KruskalMST mst = new KruskalMST();
//        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5},
//                {1, 3, 1}, {2, 3, 8}};
//        int sol = mst.solution(4, costs);
//        System.out.println(sol);

        int costs[][] = {{1, 2, 2},
                {1, 3, 3},
                {1, 4, 1},
                {1, 5, 10},
                {2, 4, 2},
                {3, 4, 1},
                {3, 5, 1},
                {4, 5, 3},
                {3, 5, 10},
                {3, 1, 8},
                {1, 4, 2},
                {5, 1, 7},
                {3, 4, 2},
                {5, 2, 4}};
        FloyWarshall(5, 14, costs);
    }

}
