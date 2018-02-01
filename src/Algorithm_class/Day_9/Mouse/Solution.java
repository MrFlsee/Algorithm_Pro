package Algorithm_class.Day_9.Mouse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    static int T;
    static int n, m;
    static long[] dist = new long[121212];
    static class xy implements Comparable<xy> {
        int x;
        int y;
        int cost;

        public xy(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

       /* @Override
        public String toString() {
            return "xy{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    '}';
        }*/

        @Override
        public int compareTo(xy o) {
            return this.cost - o.cost;
        }
    }

//    static xy[] info = new xy[321212];
    static ArrayList<xy> info;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());
            info = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                int b = Integer.parseInt(s.nextToken());
                int c = Integer.parseInt(s.nextToken());

                info.add(new xy(a, b, c));
//                info.add(new xy(b, a, c));
            }

            Collections.sort(info);

            /*for (int i = 0; i < m; i++) {
                System.out.println(info[i]);
            }*/

            dist[1] = 0;

            for (int i = 2; i <= n; i++) {
                dist[i] = -1;
            }

            for (int i = 0; i < info.size(); i++) {
                xy cur = info.get(i);

                if(dist[cur.x] == -1)
                    continue;
                if(dist[cur.y] == -1)
                    dist[cur.y] = dist[cur.x] + cur.cost;
                else {
                    long dx = dist[cur.x];
                    long dy = dist[cur.y];
                    dist[cur.y] = dx + cur.cost;
                    dist[cur.x] = dy + cur.cost;
                }
            }

            long ans = 0;
            for (int i = 1; i <= n; i++) {
                ans += dist[i];
            }

            bw.write("#" + String.valueOf(t) + " " + String.valueOf(ans) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
