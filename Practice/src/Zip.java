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
        for (int i=2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {4, 3}};
        Zip zip = new Zip();
        int[][] b = zip.clockwiseRotatedBox(a);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

}
