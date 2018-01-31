package Algorithm_class.Day_4.LCS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {
    static char[] a;
    static char[] b;
    static int[][] dp, direction;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        a = new char[1212];
        b = new char[1212];

        int s1len = s1.length();
        int s2len = s2.length();

        for (int i = 1; i <= s1len; i++) {
            a[i] = s1.charAt(i - 1);
        }

        for (int i = 1; i <= s2len; i++) {
            b[i] = s2.charAt(i - 1);
        }


        dp = new int[s2len + 1][s1len + 1];
        direction = new int[s2len + 1][s1len + 1];

        for (int i = 1; i <= s2len; i++) {
            for (int j = 1; j <= s1len; j++) {

                if (b[i] == a[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    direction[i][j] = 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        direction[i][j] = 2; //up
                    } else if (dp[i][j - 1] > dp[i - 1][j]) {
                        direction[i][j] = 3; //left
                    } else if (dp[i - 1][j] == dp[i][j - 1]) {
                        direction[i][j] = 3; // up & left
                    }
                }
            }
        }



//        for (int i = 1; i <= s2len; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println();
//        for (int i = 1; i <= s2len; i++) {
//            System.out.println(Arrays.toString(direction[i]));
//        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = dp[s2len][s1len];

        int y = s2len;
        int x = s1len;
        String result = "";
        while (max >= 0) {
            if (x < 0 || y < 0) {
                break;
            }

            if (direction[y][x] == 1) {
                result += b[y];
                max--;
                x--;
                y--;
            } else if (direction[y][x] == 2) { //up
                y--;
            } else if (direction[y][x] == 3) { //left
                x--;
            } else if (direction[y][x] == 0) {
                break;
            }

        }
        bw.write(new StringBuffer(result).reverse().toString());
        bw.flush();
        bw.close();


    }
}
