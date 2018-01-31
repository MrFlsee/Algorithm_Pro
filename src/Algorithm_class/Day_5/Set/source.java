package Algorithm_class.Day_5.Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    static int n, m;
    static int[] a, b;
    static int[][] D, MD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        a = new int[1212];
        b = new int[1212];

        D = new int[1212][1212];
        MD = new int[1212][1212];

        if (n < m) {
            s = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s.nextToken());
            }
            s = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(s.nextToken());
            }
        } else {
            s = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(s.nextToken());
            }
            s = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(s.nextToken());
            }

            int temp = n;
            n = m;
            m = temp;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        D[0][0] = abs(a[0] - b[0]);
        MD[0][0] = D[0][0];

        for (int i = 1; i < m; i++) {
            D[0][i] = abs(a[0] - b[i]);
            MD[0][i] = Math.min(D[0][i], MD[0][i - 1]);
        }

        for (int i = 1; i < n; i++) {
            D[i][i] = MD[i - 1][i - 1] + abs(a[i] - b[i]);
            MD[i][i] = D[i][i];
            for (int j = i+1; j < m; j++) {
                D[i][j] = MD[i - 1][j - 1] + abs(a[i] - b[i]);
                MD[i][j] = Math.min(MD[i][j - 1], D[i][j]);
            }
        }


        System.out.println(MD[n - 1][m - 1]);
    }

    private static int abs(int i) {
        return (i < 0) ? -i : i;
    }
}
