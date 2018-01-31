package Algorithm_class.Day_5.Stone_bridge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
    static char[] S = new char[21];
    static char[][] M = new char[2][101];

    static int[][][] D = new int[21][2][101];
    static int[][][] SD = new int[21][2][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        for (int i = 1; i <= tmp.length(); i++) {
            S[i] = tmp.charAt(i - 1);
        }
        tmp = br.readLine();
        for (int i = 1; i <= tmp.length(); i++) {
            M[0][i] = tmp.charAt(i - 1);
        }
        tmp = br.readLine();
        int klen = tmp.length();
        for (int i = 1; i <= tmp.length(); i++) {
            M[1][i] = tmp.charAt(i - 1);
        }

        D[0][0][0] = SD[0][0][0] = 1;
        D[0][1][0] = SD[0][1][0] = 1;
        for (int j = 0; j < 2; j++) {
            for (int k = 1; k <= klen; k++) {
                SD[0][j][k] = 1;
            }
        }

        int i, k = 0;
        for (i = 1; i < S.length; i++) {
            if (S[i] == 0)
                break;
            for (int j = 0; j < 2; j++) {
                for (k = 1; k <= klen; k++) {
                    if (S[i] == M[j][k]) {
                        D[i][j][k] = SD[i - 1][(j == 0) ? 1 : 0][k - 1];
                    } else {
                        D[i][j][k] = 0;
                    }

                    SD[i][j][k] = SD[i][j][k - 1] + D[i][j][k];
                }
            }
        }

        System.out.println(SD[i - 1][0][k - 1] + SD[i - 1][1][k - 1]);
    }
}
