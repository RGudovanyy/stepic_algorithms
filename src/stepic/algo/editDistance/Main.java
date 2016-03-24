package stepic.algo.editDistance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.min;

public class Main {

    public static int editDistBU(String A, String B){
        int n = A.length(), m = B.length();
        int D[][] = new int[n + 1][m + 1];
        int i, j, C;
        for( i = 0; i <= n; i++ )
            D[i][0] = i;
        for( j = 0; j <= m; j++ )
            D[0][j] = j;
        for( i = 1; i <= n; i++ ) {
            for (j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    C = 0;
                else
                    C = 1;
                D[i][j] = min(min(D[i - 1][j] + 1,
                        D[i][j - 1] + 1),
                        D[i - 1][j - 1] + C);
            }
        }
        return D[n][m];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        String B = reader.readLine();
        System.out.println(editDistBU(A,B));
    }
}
