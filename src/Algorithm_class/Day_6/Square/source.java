package Algorithm_class.Day_6.Square;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int n;
    static int[][] M = new int[3121][3121];
    static int[][] D = new int[3121][3121];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                M[i][j] = Integer.parseInt(s.nextToken());
            }
        }
    }

}
