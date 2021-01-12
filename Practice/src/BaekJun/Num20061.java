package BaekJun;

import java.util.ArrayList;
import java.util.Scanner;

public class Num20061 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<int[]> green = new ArrayList<>();
        ArrayList<int[]> blue = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            green.add(0, new int[4]);
            blue.add(0, new int[4]);
        }
        for (int idx = 0; idx < N; idx++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (t == 1) {
                // green
                int i;
                for (i = 0; i <= 5; i++) {
                    if (green.get(i)[y] == 1) {
                        break;
                    }
                }
                green.get(i - 1)[y] = 1;

                // blue
                int j;
                for (j = 0; j <= 5; j++) {
                    if (blue.get(j)[3 - x] == 1) {
                        break;
                    }
                }
                blue.get(j - 1)[3 - x] = 1;

            } else if (t == 2) {
                // green
                int i;
                for (i = 0; i <= 5; i++) {
                    if (green.get(i)[y] == 1 || green.get(i)[y + 1] == 1) {
                        break;
                    }
                }
                green.get(i - 1)[y] = 1;
                green.get(i - 1)[y + 1] = 1;
                // blue
                int j;
                for (j = 0; j <= 4; j++) {
                    if (blue.get(j)[3 - x] == 1 || blue.get(j + 1)[3 - x] == 1) {
                        break;
                    }
                }
                blue.get(j - 1)[3 - x] = 1;
                blue.get(j)[3 - x] = 1;
            } else {
                // green
                int i;
                for (i = 0; i <= 4; i++) {
                    if (green.get(i)[y] == 1 || green.get(i + 1)[y] == 1) {
                        break;
                    }
                }
                green.get(i - 1)[y] = 1;
                green.get(i)[y] = 1;
                // blue
                int j;
                for (j = 0; j <= 5; j++) {
                    if (blue.get(j)[3 - x] == 1 || blue.get(j)[2 - x] == 1) {
                        break;
                    }
                }
                blue.get(j - 1)[3 - x] = 1;
                blue.get(j - 1)[2 - x] = 1;
            }
            // delete
            for (int i = 0; i <= 5; i++) {
                boolean flag = true;
                for (int j = 0; j <= 3; j++) {
                    if (green.get(i)[j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
//                    System.out.println("green full");
                    answer++;
                    green.remove(i);
                    green.add(0, new int[4]);
                }
            }
            for (int i = 0; i <= 5; i++) {
                boolean flag = true;
                for (int j = 0; j <= 3; j++) {
                    if (blue.get(i)[j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
//                    System.out.println("blue full");

                    answer++;
                    blue.remove(i);
                    blue.add(0, new int[4]);
                }
            }
            int remove = 0;
            for (int i = 0; i < 2; i++) {
                boolean flag = false;
                for (int j = 0; j < 4; j++) {
                    if (green.get(i)[j] == 1) {
                        remove = 2 - i;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            for (int i = 0; i < remove; i++) {
                green.remove(5);
//                System.out.println("remove green " + remove);
                green.add(0, new int[4]);
            }
            remove = 0;
            for (int i = 0; i < 2; i++) {
                boolean flag = false;
                for (int j = 0; j < 4; j++) {
                    if (blue.get(i)[j] == 1) {
                        remove = 2 - i;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            for (int i = 0; i < remove; i++) {
                blue.remove(5);
                blue.add(0, new int[4]);
//                System.out.println("remove blue " + remove);
            }
            for (int i = 0; i <= 5; i++) {
                for (int j = 0; j <= 3; j++) {
                    System.out.print(green.get(i)[j] + " ");
                }
                System.out.println();
            }
            for (int j = 0; j <= 3; j++) {
                for (int i = 0; i <= 5; i++) {
                    System.out.print(blue.get(i)[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        int count = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                if (green.get(i)[j] == 1) count++;
                if (blue.get(i)[j] == 1) count++;
            }
        }

        System.out.println(answer);
        System.out.println(count);
    }
}
