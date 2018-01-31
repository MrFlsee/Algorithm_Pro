package Algorithm_class.Day_6.Dong_gul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    static int n, h;
    static int[] a = new int[121212];
    static int[] SH = new int[515151];
    static int[] JH = new int[515151];
    static int[] b = new int[121212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        h = Integer.parseInt(s.nextToken());


        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i / 2] = Integer.parseInt(br.readLine());
            } else {
                b[i / 2] = h - Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(a, 0, n / 2);
        Arrays.sort(b, 0, n / 2);

        int now = 0;
        for (int i = 1; i <= h; i++) {
            while (now < n / 2 && a[now] < i) {
                now++;
            }
            SH[i] = n / 2 - now;
        }

        now = 0;
        for (int i = 1; i <= h; i++) {
            while (now < n / 2 && b[now] < i) {
                now++;
            }
            JH[i] = now;
        }

        int ans = -1;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            if (ans == -1 || JH[i] + SH[i] < ans) {
                ans = JH[i] + SH[i];
            }

        }
        for (int i = 1; i <= h; i++) {
            if (ans == JH[i] + SH[i]) {
                cnt++;
            }
        }

        System.out.printf("%d %d", ans, cnt);

        }
}
