package Algorithm_class.Day_9.Mouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, m;

    static class xy implements Comparable<xy> {
        int x;
        int y;
        int cost;

        public xy(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(xy o) {
            return this.cost - o.cost;
        }
    }

    static xy[] info = new xy[121212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());


            for (int i = 0; i < m; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                int b = Integer.parseInt(s.nextToken());
                int c = Integer.parseInt(s.nextToken());

                info[i] = new xy(a, b, c);
            }

            Arrays.sort(info);


        }
    }
}
