package Algorithm_class.Day_6.Nuget;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    static int n;
    static long[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new long[121212];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a, 0, n);

        long now = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > now + 1) {
                System.out.println(now + 1);
                return;
            }
            now += a[i];
        }
        System.out.println(now + 1);

    }

}
