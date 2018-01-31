package Algorithm_class.Day_7.Boy_scout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
    static int n;
    static xy[] a = new xy[121];
    static xy P;
    static int[][] D = new int[121][121];
    static class xy {
        double x, y;

        public xy(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "xy{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        P = new xy(1e6 + 1, 1e6 + 1);
        StringTokenizer s;
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());
            a[i] = new xy(Double.parseDouble(s.nextToken()), Double.parseDouble(s.nextToken()));
            if (a[i].y < P.y)
                P = a[i];
            if (a[i].y == P.y && a[i].x < P.x)
                P = a[i];
        }


        Arrays.sort(a, 0, n, new Comparator<xy>() {
            @Override
            public int compare(xy a, xy b) {
                double k = ccw(P, a, b);
                if (k == 0)
                    return (dist(P, a) - dist(P, b) > 0) ? 1 : -1;
                return (k > 0) ? -1 : 1;
            }
        });

        for (int t = 0; t < n; t++) {
            for (int i = t; i < n; i++) {

            }
        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    private static double ccw(xy a, xy b, xy c) {
        return a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
    }

    private static double dist(xy a, xy b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }


}
