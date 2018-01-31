package Algorithm_class.Day_4.Rod_cutting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int N;

    static long[] p;
    static long[] r;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        p = new long[9999];
        r = new long[9999];

        N = Integer.parseInt(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(s.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            long rmax = -1;
            for (int j = 0; j < i; j++) {
                long R = p[i - j] + r[j];

                if (rmax < R) {
                    rmax = R;
                }
            }

            r[i] = rmax;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(r[N]));
        bw.flush();
        bw.close();

    }
}
