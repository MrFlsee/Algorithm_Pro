package Algorithm_class.Day_5.max_psum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int N;
    static long d[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        d = new long[1212121];

        N = Integer.parseInt(br.readLine());
        int[] a = new int[1212121];
        StringTokenizer s = new StringTokenizer(br.readLine());

        long ans = (long) -1e18;
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(s.nextToken());
            d[i] = Math.max(d[i - 1] + a[i], a[i]);
            ans = Math.max(ans, d[i]);
        }

        System.out.println(ans);
    }
}
