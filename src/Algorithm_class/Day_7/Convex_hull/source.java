package Algorithm_class.Day_7.Convex_hull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {
    static int n;
    static xy[] a = new xy[121212];
    static xy P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        P = new xy(414141, 414141);

        StringTokenizer s;
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());

            a[i] = new xy(Long.parseLong(s.nextToken()), Long.parseLong(s.nextToken()));
            if (a[i].y < P.y)
                P = a[i];
            if (P.y == a[i].y && a[i].x < P.x)
                P = a[i];
        }

        Arrays.sort(a, 0, n, new Comparator<xy>() {
            @Override
            public int compare(xy a, xy b) {
                long k = ccw(P, a, b);
                if (k == 0)
                    return (dist(P, a) - dist(P, b) > 0) ? 1 : -1;
                return (k > 0) ? -1 : 1;
            }
        });

//        System.out.println(P);
//        for (int i = 0; i < n; i++) {
//            System.out.println(a[i]);
//        }

        Stack<xy> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() >= 2 && ccw(st.get(st.size() - 2), a[i], st.get(st.size() - 1)) >= 0) {
                st.pop();
            }

            st.push(a[i]);
        }

        System.out.println(st.size());


    }

    private static long dist(xy a, xy b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static long ccw(xy a, xy b, xy c) {
        return a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
    }

    static class xy {
        long x;
        long y;

        public xy(long x, long y) {
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
}
