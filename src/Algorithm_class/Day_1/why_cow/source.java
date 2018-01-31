package Algorithm_class.Day_1.why_cow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {
    static int N;
    static int[] s1, s2;
    static int[] a1, a2;
    static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        s1 = new int[N];
        a1 = new int[N + 1];
        a2 = new int[N + 1];
        s2 = new int[N];

        for (int i = 0; i < N; i++) {
            s1[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            s2[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            a1[s2[i]] = i;
            a2[s1[i]] = i;
        }


        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(a1));




    }
}
