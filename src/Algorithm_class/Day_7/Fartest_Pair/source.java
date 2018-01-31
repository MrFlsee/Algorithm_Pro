package Algorithm_class.Day_7.Fartest_Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class source {
    static int n;
    static xy[] a = new xy[212121];
    static xy P;

    static class xy {
        long x, y;

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

    static int ccw(xy a, xy b, xy c) {
        long k = a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
        if (k > 0) {
            return 1;
        }
        if (k < 0) {
            return -1;
        }
        return 0;
    }

    static long dist(xy a, xy b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        P = new xy((long) 1e9, (long) 1e9);

        StringTokenizer s;
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());

            a[i] = new xy(Long.parseLong(s.nextToken()), Long.parseLong(s.nextToken()));
            if (P.y > a[i].y) P = a[i];
            if (P.y == a[i].y && P.x > a[i].x)
                P = a[i];
        }

        Arrays.sort(a, 0, n, new Comparator<xy>() {
            @Override
            public int compare(xy a, xy b) {
                long k = ccw(P, a, b);
                if (k == 0) {
                    return (dist(P, a) > dist(P, b)) ? 1 : -1;
                }
                return (k > 0) ? -1 : 1;
            }
        });

        Stack<xy> st = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (st.size() >= 2 && ccw(st.get(st.size() - 2), st.peek(), a[i]) <= 0) {
                st.pop();
            }

            st.push(a[i]);
        }

        long ans = -1;
        int p1 = 0;
        int p2 = 1;

        for (p1 = 0; p1 < st.size(); p1++) {
            int nextp1 = (p1 + 1) % st.size();
            int nextp2 = (p2 + 1) % st.size();

            while (ccw(new xy(0, 0), dydx(st.get(p1), st.get(nextp1)), dydx(st.get(p2), st.get(nextp2))) < 0) {
                p2 = nextp2;
                nextp2 = (p2 + 1) % st.size();
            }

            ans = Math.max(ans, dist(st.get(p1), st.get(p2)));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans + "\n"));
        bw.flush();
        bw.close();
    }

    private static xy dydx(xy a, xy b) {
        return new xy(a.x - b.x, a.y - b.y);
    }
}
