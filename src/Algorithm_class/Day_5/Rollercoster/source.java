package Algorithm_class.Day_5.Rollercoster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class source {
    static int l, n, b;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());

        l = Integer.parseInt(s.nextToken());
        n = Integer.parseInt(s.nextToken());
        b = Integer.parseInt(s.nextToken());

        d = new int[1212][1212];


        ArrayList<Part>[] L = new ArrayList[1001];
        for (int i = 1; i < 1001; i++) {
            L[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(s.nextToken());
            int w = Integer.parseInt(s.nextToken());
            int f = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            L[x + w].add(new Part(x, w, f, c));
        }

        for (int i = 1; i < b; i++) {
            d[0][i] = -1;
        }

        for (int i = 1; i <= l; i++) {
            for (int j = 0; j <= b; j++) {
                d[i][j] = -1;
                for (int k = 0; k < L[i].size(); k++) {
                    if (j - L[i].get(k).c < 0) continue;
                    if (d[L[i].get(k).x][j - L[i].get(k).c] == -1) continue;
                    if (d[i][j] == -1 || d[i][j] < (d[L[i].get(k).x][j - L[i].get(k).c] + L[i].get(k).f))
                        d[i][j] = d[L[i].get(k).x][j - L[i].get(k).c] + L[i].get(k).f;
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= b; i++) {
            if (d[l][i] == -1) continue;
            if (ans == -1 || ans < d[l][i]) ans = d[l][i];

        }

        System.out.println(ans);
    }

    static class Part {
        int x, w, f, c;

        public Part(int x, int w, int f, int c) {
            this.x = x;
            this.w = w;
            this.f = f;
            this.c = c;
        }
    }
}
