package Algorithm_class.Day_2.sliding_window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    static int n, k;
    static int[] a = new int[1212121];
    static long[] S = new long[1212121];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        k = Integer.parseInt(s.nextToken());

        Deque<Integer> mx, mxw;
        Deque<Integer> mn, mnw;

        mx = new LinkedList<>();
        mxw = new LinkedList<>();
        mn = new LinkedList<>();
        mnw = new LinkedList<>();

        s = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s.nextToken());
            S[i] = S[i - 1] + a[i];

            while (!mn.isEmpty() && mn.peekLast() > a[i]) {
                mn.pollLast();
                mnw.pollLast();
            }

            while (!mx.isEmpty() && mx.peekLast() < a[i]) {
                mx.pollLast();
                mxw.pollLast();
            }

            mn.addLast(a[i]);
            mnw.addLast(i);
            mx.addLast(a[i]);
            mxw.addLast(i);

            while (mnw.peekFirst() <= i - k) {
                mn.pollFirst();
                mnw.pollFirst();
            }

            while (mxw.peekFirst() <= i - k) {
                mx.pollFirst();
                mxw.pollFirst();
            }

            if (i >= k) {

                bw.write(String.valueOf(mn.peekFirst()));
                bw.write(" ");
                bw.write(String.valueOf(mx.peekFirst()));
                bw.write(" ");
                bw.write( String.valueOf(S[i] - S[i - k]));
                bw.write("\n");

            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
