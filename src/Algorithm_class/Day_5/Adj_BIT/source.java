package Algorithm_class.Day_5.Adj_BIT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[][][] d = new int[121][121][2];


        d[1][0][0] = 1;
        d[1][0][1] = 1;

        for (int i = 2; i <= 100; i++) {
            d[i][0][0] = d[i - 1][0][0] + d[i - 1][0][1];
            d[i][0][1] = d[i - 1][0][0];

            for (int j = 1; j <= i; j++) {
                d[i][j][0] = d[i - 1][j][0] + d[i - 1][j][1];
                d[i][j][1] = d[i - 1][j][0] + d[i - 1][j - 1][1];
            }
        }

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int tt = Integer.parseInt(s.nextToken());
            int n = Integer.parseInt(s.nextToken());
            int k = Integer.parseInt(s.nextToken());



            bw.write(String.valueOf(tt) + " " + String.valueOf(d[n][k][0] + d[n][k][1]) + "\n");

        }

        bw.flush();
        bw.close();

    }
}
