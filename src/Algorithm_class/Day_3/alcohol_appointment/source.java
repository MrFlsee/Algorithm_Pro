package Algorithm_class.Day_3.alcohol_appointment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[][] app;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        app = new int[N][2];

        StringTokenizer s;
        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());
            app[i][0] = Integer.parseInt(s.nextToken());
            app[i][1] = Integer.parseInt(s.nextToken());
        }

        Arrays.sort(app, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[0] * o2[1] - o2[0] * o1[1];
                return o1[0] * o2[1] - o2[0] * o1[1];
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(app[i]));
//        }

        long now = 0;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += now * app[i][1];

            now += app[i][0] * 2;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
