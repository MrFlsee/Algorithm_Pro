package Algorithm_class.Day_9.Crime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int n, k;
    static ArrayList<Integer>[] redge = new ArrayList[121212];
    static int[][] D = new int[121212][121];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= T; t++) {
            StringTokenizer s = new StringTokenizer(br.readLine());

            n = Integer.parseInt(s.nextToken());
            k = Integer.parseInt(s.nextToken());

            for (int i = 1; i <= n; i++) {
                redge[i] = new ArrayList<>();
            }
            for (int i = 0; i < n-1; i++) {
                s = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(s.nextToken());
                int b = Integer.parseInt(s.nextToken());

                redge[b].add(a);
                redge[a].add(b);
            }

            s = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                D[i][0] = Integer.parseInt(s.nextToken());
            }

        }
    }
}
