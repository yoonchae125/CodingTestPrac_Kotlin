package programmers_practice.level3;

import java.util.HashMap;

public class LengthOfVisit {
    public int solution(String dirs) {
        int answer = 0;

        int x = 0;
        int y = 0;
        HashMap<String, Integer> check = new HashMap();
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            Edge e = new Edge(new Point(0, 0), new Point(0, 0));
            int nx = 0;
            int ny = 0;
            switch (c) {
                case 'U':
                    nx = x;
                    ny = y + 1;
                    if (ny < -5 || ny > 5)
                        continue;
                    e = new Edge(new Point(x, y), new Point(nx, ny));
                    break;
                case 'D':
                    nx = x;
                    ny = y - 1;
                    if (ny < -5 || ny > 5)
                        continue;
                    e = new Edge(new Point(x, y), new Point(nx, ny));
                    break;
                case 'R':
                    nx = x + 1;
                    ny = y;
                    if (nx < -5 || nx > 5)
                        continue;
                    e = new Edge(new Point(x, y), new Point(nx, ny));
                    break;
                case 'L':
                    nx = x - 1;
                    ny = y;
                    if (nx < -5 || nx > 5)
                        continue;
                    e = new Edge(new Point(x, y), new Point(nx, ny));
                    break;
            }
            if (!check.containsKey(e.toString())) {
                answer++;
            }
            check.put(e.toString(), 0);

            x = nx;
            y = ny;
        }

        return answer;
    }

    class Edge {
        Point start;
        Point end;

        Edge(Point p1, Point p2) {
            if (p1.x < p2.x) {
                start = p1;
                end = p2;
            } else if (p1.x == p2.x) {
                if (p1.y < p2.y) {
                    start = p1;
                    end = p2;
                } else {
                    start = p2;
                    end = p1;
                }
            } else {
                start = p2;
                end = p1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Edge e = (Edge) obj;
            if (e.start == this.start && e.end == this.end) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            String str = this.start + " " + this.end;
            return str;
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            if (p.x == this.x && p.y == this.y) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            String str = this.x + " " + this.y;
            return str;
        }
    }
}
