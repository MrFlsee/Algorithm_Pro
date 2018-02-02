package Algorithm_class.Day_10.Material;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[기출P-0026] 커지는 결정 물질
 */
public class Solution {
    static int T;
    static int n;
    static class M implements Comparable<M>{
        int n, x, y, area, v, dense;

        public M(int n, int x, int y, int area, int v, int dense) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.area = area;
            this.v = v;
            this.dense = dense;
        }

        @Override
        public int compareTo(M o) {
            return o.dense - this.dense;
        }
    }
    static M[] a = new M[1212];
    static info[] D = new info[1212];
    static class info implements Comparable<info>{
        int n;
        double time;

        public info(int n, double time) {
            this.n = n;
            this.time = time;
        }

        @Override
        public int compareTo(info o) {
            return this.time - o.time > 0 ? 1 : -1;
        }

        @Override
        public String toString() {
            return "info{" +
                    "n=" + n +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer s ;
            for (int i = 1; i <= n; i++) {
                s = new StringTokenizer(br.readLine());
                a[i] = new M(i, Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
            }

            Arrays.sort(a, 1, n);

            StringBuffer sb = new StringBuffer();

            D[1] = new info(a[1].n, 1e9);

            for (int i = 2; i <= n; i++) {
                Double min = 1e9;
                int minj = 0;
                for (int j = 1; j < i; j++) {
                    double time = getTime(i, j);
                    if (D[j].time > time && min > time) {
                        min = time;
                        minj = a[i].n;
                    }
                }
                D[i] = new info(minj, min);
            }

//            for (int i = 1; i <= n; i++) {
//                System.out.print(D[i]);
//            }
//
//            System.out.println();

            Arrays.sort(D, 1, n+1);

            bw.write("#" + t + " ");
            for (int i = 1; i <= n; i++) {
                bw.write(String.valueOf(D[i].n + " "));
            }
            bw.write("\n");
        }

        bw.flush();
    }

    private static double getTime(int c1, int c2) {
        M A = a[c1];
        M B = a[c2];

        return (max(abs(B.y - A.y), abs(B.x - A.x)) - (A.area + B.area) * 0.5) / (A.v + B.v);
    }

    private static int abs(int n) {
        return (n < 0) ? -n : n;
    }
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
