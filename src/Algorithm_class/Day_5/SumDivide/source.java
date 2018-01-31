package Algorithm_class.Day_5.SumDivide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int N, K;
    static int[][] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        K = Integer.parseInt(s.nextToken());

        d = new int[212][212];

        int mod = (int) 1e9;
        d[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            d[i][0] = d[i - 1][0];
            for (int j = 1; j <= N; j++) {
                d[i][j] = (d[i][j - 1] + d[i-1][j]) % mod;
            }
        }

        System.out.println(d[K][N]);
    }
}
