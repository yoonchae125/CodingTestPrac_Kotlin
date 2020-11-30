package programmers_practice.level2_review;

import java.util.LinkedList;
import java.util.Queue;

public class FourBlocks {
    int dx[] = {0, 1, 1};
    int dy[] = {1, 1, 0};

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            Queue<Integer> remove = new LinkedList<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c == '.')
                        continue;
                    boolean flag = true;
                    for (int d = 0; d < 3; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (map[nx][ny] != c) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        remove.add(i);
                        remove.add(j);
                        for (int d = 0; d < 3; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            remove.add(nx);
                            remove.add(ny);
                        }
                    }
                }
            }
            if (remove.isEmpty())
                break;
            while (!remove.isEmpty()) {
                int x = remove.poll();
                int y = remove.poll();
                if (map[x][y] != '.') {
                    answer++;
                    map[x][y] = '.';
                }
            }
            down(m, n, map);
        }
        return answer;
    }

    public void down(int m, int n, char[][] map) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') continue;

                int nx = i;
                char c = map[i][j];
                map[i][j] = '.';
                while (true) {
                    if (nx + 1 >= m || map[nx + 1][j] != '.') break;
                    nx++;
                }
                map[nx][j] = c;
            }
        }
    }
}
