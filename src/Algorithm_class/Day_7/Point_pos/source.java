package Algorithm_class.Day_7.Point_pos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int n;
    static xy[] a = new xy[112121];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer s;
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());

            a[i] = new xy(Long.parseLong(s.nextToken()), Long.parseLong(s.nextToken()));
        }

        for (int i = 0; i < 2; i++) {
            s = new StringTokenizer(br.readLine());
            xy A = new xy(Long.parseLong(s.nextToken()), Long.parseLong(s.nextToken()));
            xy X = new xy(A.x + 1, (long) (1e9 + 1));

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (isCross(A, X, a[j], a[(j + 1) % n])) {
                    cnt++;
                }
            }

            if (cnt % 2 == 0) {
                System.out.println("in");
            } else
                System.out.println("out");
        }


    }

    private static boolean isCross(xy p1, xy p2, xy p3, xy p4) {
        if ((ccw(p1, p2, p3) * ccw(p1, p2, p4)) < 0
                && (ccw(p3, p4, p1) * ccw(p3, p4, p2) < 0)) {
            return true;
        }

        return false;
    }

    private static int ccw(xy a, xy b, xy c) {
        return ((a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x) > 0)? 1: -1 ;
    }

    static class xy {
        long x, y;

        public xy(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
