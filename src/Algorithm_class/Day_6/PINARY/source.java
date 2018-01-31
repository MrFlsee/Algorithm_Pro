package Algorithm_class.Day_6.PINARY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {
    static int n;
    static long[][] d = new long[99][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        d[1][0] = 0;
        d[1][1] = 1;

        d[2][0] = 1;
        d[2][1] = 0;

        d[3][0] = 1;
        d[3][1] = 1;

        for (int i = 4; i <= n; i++) {
            d[i][0] = d[i - 1][1] + d[i-1][0];
            d[i][1] = d[i - 1][0];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(d[n][0] + d[n][1]) + "\n");
        bw.flush();
        bw.close();
    }



}
