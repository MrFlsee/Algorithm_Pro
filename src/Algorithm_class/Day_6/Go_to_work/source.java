package Algorithm_class.Day_6.Go_to_work;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int h, w, n;
    static int[][] map = new int[1212][1212];
    static int[][] d = new int[1212][1212];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        h = Integer.parseInt(s.nextToken());
        w = Integer.parseInt(s.nextToken());
        n = Integer.parseInt(s.nextToken());

        for (int i = 1; i <= h; i++) {
            s = new StringTokenizer(br.readLine());

            for (int j = 1; j <= w; j++) {
                map[i][j] = Integer.parseInt(s.nextToken());
            }
        }


        d[1][1] = n - 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (i == 1 && j == 1)
                    continue;

                if (map[i - 1][j] == 0)
                    d[i][j] += d[i - 1][j] / 2 + d[i - 1][j] % 2;
                else
                    d[i][j] += d[i - 1][j] / 2;

                if (map[i][j - 1] == 1)
                    d[i][j] += d[i][j - 1] / 2 + d[i][j - 1] % 2;
                else
                    d[i][j] += d[i][j - 1] / 2;
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (d[i][j] % 2 == 1)
                    map[i][j] = (map[i][j] == 0) ? 1 : 0;
            }
        }

        int nowx = 1, nowy = 1;
        while (nowx <= h && nowy <= w) {
            if (map[nowx][nowy] == 0)
                nowx++;
            else
                nowy++;
        }

        System.out.printf("%d %d", nowx, nowy);

    }
}
