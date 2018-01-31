package Algorithm_class.Day_2.center;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class source {
    static int N;
    static Queue<Integer> maxHeap, minHeap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

        int center = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(center) + "\n");
        maxHeap.offer(center);
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (maxHeap.peek() > n) {
                maxHeap.offer(n);
            } else {
                minHeap.offer(n);
            }

            if (maxHeap.size() < minHeap.size()) {
                int tmp = minHeap.poll();
                maxHeap.offer(tmp);
            } else if(maxHeap.size() > minHeap.size() + 1){
                int tmp = maxHeap.poll();
                minHeap.offer(tmp);
            }

            if (i % 2 == 0) {
                bw.write(String.valueOf(maxHeap.peek()) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
