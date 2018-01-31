package Algorithm_class.Day_3.power;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
    static long a, m;
    static final int DIV = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(br.readLine());
        a = Long.parseLong(s.nextToken());
        m = Long.parseLong(s.nextToken());
        long ans = f(a, m);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long f(long a, long m) {

        if (m == 0) {
            return 1;
        }

        long x = f(a, m / 2);

//        return (x * x % DIV * (m % 2 == 1 ? a : 1)) % DIV;
        if (m % 2 == 0) {
            return x * x % DIV;
        } else {
            return x * x % DIV * a % DIV;
        }

    }
}
