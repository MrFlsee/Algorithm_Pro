package Algorithm_class.Day_9.Scissors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, k;
    static int[] a = new int[1212];
    static int[][] D = new int[1212][1212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            k = Integer.parseInt(s.nextToken());

            s = new StringTokenizer(br.readLine());

            int mx = -1;
            int mn = (int) 1e9;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s.nextToken());

                if(mx < a[i])
                    mx = a[i];

                if(mn > a[i])
                    mn = a[i];

                if (i == 0) {
                    D[0][i] = a[i];
                } else {
                    D[0][i] = mx - mn;
                }
            }

//            D[0][n] = mx - mn;
//            System.out.println(D[0][n]);
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j <= n; j++) {
                    int min = (int) 1e9;
                    for (int l = 0; l < j; l++) {
                        int v = Math.max(D[i - 1][l], findV(l + 1, j));
                        if (min > v) {
                            min = v;
                        }
                    }
                    if (j == 0) {
                        D[i][j] = D[i - 1][j];
                    } else {
                        D[i][j] = min;
                    }
                }

            }
            System.out.println("#" + t + " " + D[k][n]);

        }
    }

    private static int findV(int s, int e) {
        int mx = -1;
        int mn = (int) 1e9;

        if (s == e) {
            return a[s];
        }

        for (int i = s; i <= e; i++) {
            if(mx < a[i])
                mx = a[i];

            if(mn > a[i])
                mn = a[i];
        }
        return mx-mn;
    }


}
