package Algorithm_class.Day_5.Paper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[][] map, d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        d = new int[N + 1][N + 1];

        StringTokenizer s;
        for (int i = 1; i <= N; i++) {
            s = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]) + map[i][j];
            }
        }

        System.out.println(d[N][N]);

    }
}
