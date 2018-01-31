package Algorithm_class.Day_7.Polygon_area;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int n;
    static long[][] P = new long[121212][2];
    static double[] G = new double[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            P[i][0] = Long.parseLong(s.nextToken());
            P[i][1] = Long.parseLong(s.nextToken());
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += P[i][0] * P[(i + 1) % n][1];
            ans -= P[i][1] * P[(i + 1) % n][0];
        }

        if (ans < 0)
            System.out.printf("%d.%d", -ans / 2, (ans % 2 == 0) ? 0 : 5);
        else
            System.out.printf("%d.%d", ans / 2, (ans % 2 == 0) ? 0 : 5);


    }

}
