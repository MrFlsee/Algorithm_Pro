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
            }

            D[0][n] = mx - mn;



        }
    }


}
