package Algorithm_class.Day_8.Warp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dp {
    static int n, m;
    static ArrayList<p>[] redge = new ArrayList[121212];
    static long[] d = new long[121212];
    static class p {
        int n;
        int dist;

        public p(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= n; i++) {
            redge[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            redge[b].add(new p(a, c));
        }
        Arrays.fill(d, -1);
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (p before : redge[i]) {
                if (d[before.n] == -1) {
                    continue;
                }

                if(d[i] == -1 || d[i] > d[before.n] + before.dist)
                    d[i] = d[before.n] + before.dist;
            }
            /*for (int j = 0; j < redge[i].size(); j++) {
                if(d[redge[i].get(j).n] == -1)
                    continue;
                if(d[i] == -1 || d[i] > d[redge[i].get(j).n] + redge[i].get(j).dist)
                    d[i] = d[redge[i].get(j).n] + redge[i].get(j).dist;

            }*/
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(d[n]) + "\n");
        bw.flush();
        bw.close();
    }
}
