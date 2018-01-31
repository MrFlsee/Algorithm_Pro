package Algorithm_class.Day_1.Sosu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class source {
    static int T;
    static int start, end;
    static boolean[] prime;
    static int cnt;
    static int dist[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        prime = new boolean[12121];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            cnt = Integer.MAX_VALUE;

            dist = new int[10000];

            dist[start] = 1;
            Queue<Integer> que = new LinkedList<>();
            que.offer(start);
            while (!que.isEmpty()) {
                int now = que.poll();
                for (int i = 0; i <= 9; i++) {
                    for (int j = 1; j <= 1000; j *= 10) {
                        if(j == 1000 && i == 0)
                            continue;

                        int next = now - now / j % 10 * j + i * j;

                        if (prime[next]) {
                            continue;
                        }

                        if (dist[next] > 0) {
                            continue;
                        }

                        dist[next] = dist[now] + 1;
                        que.offer(next);
                    }
                }
            }

            System.out.println(dist[end] - 1);
        }
    }

}
