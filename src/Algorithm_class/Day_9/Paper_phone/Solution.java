package Algorithm_class.Day_9.Paper_phone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, m;
    static int[][] D = new int[212][212];
    static int[][] M = new int[212][212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());

            for (int i = 0; i < m; i++) {
                s = new StringTokenizer(br.readLine());

                int fr = Integer.parseInt(s.nextToken());
                int to = Integer.parseInt(s.nextToken());
                M[fr][to] = 1;
                M[to][fr] = 1;
            }


            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j + i - 1 <= n; j++) {
                    if(i == 1)
                        continue;

//                    D[j][j + i - 1] = cnt++;
                    if (M[j][i] == 1) {
                        D[j][i] += 1 + D[j + 1][i - 1];
                    } else {
                        int max = -1;
                        for (int k = j; k < j + i; k++) {
                            if(D[j][k] + D[k+1][i] > max)
                                max = D[j][k] + D[k+1][i];
                        }
                        D[j][i] = max;
                    }
                }
            }

            /*for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.printf("%3d", D[i][j]);
                }
                System.out.println();
            }*/

            System.out.println("#" + t + " " + D[1][n]);
        }
    }
}
