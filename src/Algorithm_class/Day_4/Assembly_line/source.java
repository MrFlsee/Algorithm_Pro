package Algorithm_class.Day_4.Assembly_line;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int n;
    static int e1, e2, x1, x2;
    static int[] s1, s2;
    static int[] t1, t2;

    static long[] before;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        e1 = Integer.parseInt(s.nextToken());
        e2 = Integer.parseInt(s.nextToken());
        x1 = Integer.parseInt(s.nextToken());
        x2 = Integer.parseInt(s.nextToken());

        s1 = new int[999999];
        s2 = new int[999999];
        t1 = new int[999999];
        t2 = new int[999999];

        before = new long[2]; // 0: s1 // 1: s2

        s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s1[i] = Integer.parseInt(s.nextToken());
        }
        s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s2[i] = Integer.parseInt(s.nextToken());
        }
        s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n - 1; i++) {
            t1[i] = Integer.parseInt(s.nextToken());
        }
        s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n - 1; i++) {
            t2[i] = Integer.parseInt(s.nextToken());
        }

        before[0] = s1[1] + e1;
        before[1] = s2[1] + e2;
        for (int i = 2; i <= n; i++) {
            long a = s1[i] + Math.min(before[0], before[1] + t2[i - 1]);
            long b = s2[i] + Math.min(before[1], before[0] + t1[i - 1]);

            before[0] = a;
            before[1] = b;
        }

        before[0] += x1;
        before[1] += x2;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Math.min(before[0], before[1])));
        bw.flush();
        bw.close();

    }
}
