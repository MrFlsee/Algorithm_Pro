package Algorithm_class.Day_3.balloon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static int N;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[1212121];
        StringTokenizer s = new StringTokenizer(br.readLine());

        int[] arrows = new int[1212121];
        int arrow = 0;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(s.nextToken());

            if (arrows[h] > 0) {
                arrows[h]--;
                arrows[h - 1]++;
                continue;
            }

            if (arrow == 0) {
                arrow = h - 1;
                arrows[arrow] = 1;
                cnt++;
                continue;
            }

            if (arrow == h) {
                arrow--;
                arrows[h]--;
                arrows[h - 1]++;
            } else {
                arrow = h - 1;
                arrows[arrow]++;
                cnt++;
            }


        }



        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();

    }
}
