package stepic.algo.bag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int knapsackWithoutReps(int W, int[] w, int n){
        int[][] D = new int[W+1][n+1];
        for (int i = 1; i <= n; i++){
            for(int s = 1; s <= W; s++){
                if(w[i-1] <= s) {
                    D[s][i] = Math.max(D[s][i-1], D[s - w[i-1]][i - 1]+1);
                }else{
                    D[s][i] = D[s][i-1];
                }
            }
        }
        return D[W][n] ;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] Wn = reader.readLine().split(" ");
        int W = Integer.parseInt(Wn[0]);
        int n = Integer.parseInt(Wn[1]);
        String[] items = reader.readLine().split(" ");
        int[] w = new int[n];
        for (int i = 0; i < n; i++){
            w[i] = Integer.parseInt(items[i]);
        }
        System.out.println(knapsackWithoutReps(W,w,n));

    }

}
