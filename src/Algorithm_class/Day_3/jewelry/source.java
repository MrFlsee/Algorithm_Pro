package Algorithm_class.Day_3.jewelry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        K = Integer.parseInt(s.nextToken());

        int[][] j = new int[N][2];
        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());
            j[i][0] = Integer.parseInt(s.nextToken());
            j[i][1] = Integer.parseInt(s.nextToken());
        }

        Arrays.sort(j, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);


        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int now = 0;
        long ans = 0;
        for (int i = 0; i < K; i++) {
            while (now < N && j[now][0] <= bag[i]) {
                maxHeap.offer(j[now][1]);
                now++;
            }

            if (!maxHeap.isEmpty()) {
                ans += maxHeap.poll();
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();


    }
}
