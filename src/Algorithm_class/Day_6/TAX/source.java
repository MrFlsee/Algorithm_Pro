package Algorithm_class.Day_6.TAX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int n, k;
    static long[] a = new long[121212121];
    static long[] D = new long[101];
    static long[] ans = new long[101];
    static long[] temp = new long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        k = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mn(k, i); j++) {
                D[j] += a[i];
            }
            int j = (int) mn(k, i);
            while (j > 0 && D[j - 1] < a[i]) {
                D[j] = D[j - 1];
                j--;
            }
            D[j] = a[i];
            int p1 = 0;
            int p2 = 0;

            for (j = 0; j < mn((i + 1) * (i + 2) / 2, k); j++) {
                if (p1 == mn(k, i + 1))
                    temp[j] = ans[p2++];
                else if (p2 == mn(k, (i + 1) * i / 2))
                    temp[j] = D[p1++];
                else if (D[p1] > ans[p2])
                    temp[j] = D[p1++];
                else
                    temp[j] = ans[p2++];
            }

            for (j = 0; j < mn((i + 1) * (i + 2) / 2, k); j++) {
                ans[j] = temp[j];
            }
        }
        System.out.println(ans[k - 1]);
    }

    private static long mn(long a, long b) {
        if (a < b) {
            return a;
        }

        return b;
    }
}
