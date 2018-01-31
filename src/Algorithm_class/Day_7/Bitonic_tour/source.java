package Algorithm_class.Day_7.Bitonic_tour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class source {
    static int n;
    static xy[] a = new xy[1212];
    static double[][] D = new double[1212][1212];

    static class xy {
        long x, y;

        public xy(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer s;
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());
            a[i] = new xy(Long.parseLong(s.nextToken()), Long.parseLong(s.nextToken()));
        }

        D[1][0] = dist(a[1], a[0]);
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i - 1; j++) {
                D[i][j] = D[i - 1][j] + dist(a[i - 1], a[i]);
            }
            D[i][i - 1] = 2e9;
            for (int j = 0; j < i - 1; j++) {
                D[i][i - 1] = min(D[i][i-1], D[i-1][j] + dist(a[j], a[i]));
            }
        }

        double ans = 2e9;
        for (int i = 0; i < n - 1; i++) {
            ans = min(ans, D[n - 1][i] + dist(a[i], a[n - 1]));
        }

        System.out.printf("%.2f", ans);
    }
    private static double min(double a, double b) {
        if(a < b)
            return a;

        return b;
    }
    private static double dist(xy a, xy b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

}
