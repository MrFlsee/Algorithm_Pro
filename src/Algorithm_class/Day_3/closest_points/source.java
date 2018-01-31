package Algorithm_class.Day_3.closest_points;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[][] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        p = new int[N][2];

        StringTokenizer s;
        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());

            p[i][0] = Integer.parseInt(s.nextToken());
            p[i][1] = Integer.parseInt(s.nextToken());
        }

        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        long ans = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {

            long dis = distance(p[i - 1][0], p[i - 1][1], p[i][0], p[i][1]);
            if (ans > dis) {
                ans = dis;
            }
        }

        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 1; i < N; i++) {

            long dis = distance(p[i - 1][0], p[i - 1][1], p[i][0], p[i][1]);
            if (ans > dis) {
                ans = dis;
            }
        }

        System.out.println(ans);


    }

    private static long distance(int x1, int y1, int x2, int y2) {
        return (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
    }
}
