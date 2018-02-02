package Algorithm_class.Day_10.Guild;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, m;
    static int[] Set = new int[121212];
    static xy[] adj = new xy[121212];

    static class xy {
        int x, y;
        boolean check;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
            this.check = false;
        }
    }

    static int[][] Q = new int[212121][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());

            for (int i = 1; i <= n; i++) {
                Set[i] = i;
            }

            for (int i = 1; i <= m; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                int b = Integer.parseInt(s.nextToken());

                adj[i] = new xy(a, b);

//                union(a, b);
            }
            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                if (a == 2) {
                    int b = Integer.parseInt(s.nextToken());
                    int c = Integer.parseInt(s.nextToken());

                    Q[i][0] = a;
                    Q[i][1] = b;
                    Q[i][2] = c;
                } else {
                    int b = Integer.parseInt(s.nextToken());

                    Q[i][0] = a;
                    Q[i][1] = b;
                    adj[b].check = true;
                }
            }

            for (int i = 1; i <= m; i++) {
                if (adj[i].check)
                    continue;

                union(adj[i].x, adj[i].y);
            }


            bw.write("#" + String.valueOf(t) + " ");
            StringBuffer sb = new StringBuffer();
            for (int i = q - 1; i >= 0; i--) {
                if (Q[i][0] == 1) { // union
                    union(adj[Q[i][1]].x, adj[Q[i][1]].y);
                } else {
                    int a = Q[i][1];
                    int b = Q[i][2];
                    if (find(a) == find(b)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }

            bw.write(sb.reverse().toString());
            bw.write("\n");

        }

        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            Set[A] = B;
        }
    }

    private static int find(int n) {
        if (Set[n] == n) {
            return n;
        }

        return Set[n] = find(Set[n]);
    }
}
