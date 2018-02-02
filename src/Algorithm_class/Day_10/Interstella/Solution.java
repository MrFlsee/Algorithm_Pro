package Algorithm_class.Day_10.Interstella;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    static int T;
    static int n, m, k;
    static class pair implements Comparable<pair>{
        int n;
        long dist;
        int p;

        public pair(int n, long dist, int p) {
            this.n = n;
            this.dist = dist;
            this.p = p;
        }

        @Override
        public int compareTo(pair o) {
            return this.dist - o.dist > 0 ? 1 : -1;
        }

    }
    static ArrayList<pair>[] adj = new ArrayList[100002];
    static long[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            dist = new long[3][n + 1];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(dist[i], -1);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[u].add(new pair(v, c, 0));
                adj[v].add(new pair(u, c, 0));
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Queue<pair> pq = new PriorityQueue<>();
            pq.add(new pair(s, 0, 0));
            dist[0][s] = 0;

            while (!pq.isEmpty()) {
                pair here = pq.poll();


                if(dist[here.p][here.n] != here.dist)
                    continue;

                if (here.p == k && here.n == e) {
                    break;
                }

                for (pair there : adj[here.n]) {
                    if (dist[here.p][there.n] == -1 || dist[here.p][there.n] > here.dist + there.dist) {
                        dist[here.p][there.n] = here.dist + there.dist;
                        pq.offer(new pair(there.n, here.dist + there.dist, here.p));
                    }

                    if (here.p < 2 && (dist[here.p + 1][there.n] == -1 || dist[here.p + 1][there.n] > here.dist + 1)) {
                        dist[here.p+1][there.n] = here.dist + 1;
                        pq.offer(new pair(there.n, here.dist + 1, here.p + 1));
                    }
                }
            }

            bw.write("#" + t + " " + String.valueOf(dist[k][e]) + "\n");
        }
        bw.flush();
        bw.close();

    }
}
