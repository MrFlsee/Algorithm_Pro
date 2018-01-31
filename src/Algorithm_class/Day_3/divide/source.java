package Algorithm_class.Day_3.divide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[][] paper;
    static int[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = new int[2];
        N = Integer.parseInt(br.readLine());
        paper = new int[N + 1][N + 1];
        StringTokenizer s;
        for (int i = 1; i <= N; i++) {
            s = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        f(1, 1, N, N);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans[0]) + "\n");
        bw.write(String.valueOf(ans[1]) + "\n");
        bw.flush();
        bw.close();
    }

    private static void f(int x1, int y1, int x2, int y2) {
        boolean flag = true;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (paper[i][j] != paper[x1][y1]) {
                    flag = false;
                }
            }
        }

        if (flag) {
            ans[paper[x1][y1]]++;
            return;
        }

        int mx = x1 + (x2 - x1) / 2;
        int my = y1 + (y2 - y1) / 2;

        f(x1, y1, mx, my);
        f(mx + 1, y1, x2, my);
        f(x1, my + 1, mx, y2);
        f(mx + 1, my + 1, x2, y2);
    }
}
