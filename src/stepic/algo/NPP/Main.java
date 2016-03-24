package stepic.algo.NPP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

public class Main {
    public static int LISBottomUp(int[] A,int n){
        int[] D = new int[n];
        for(int i = 0; i < n; i++) {
            D[i] = 1;
            for(int j = 0; j < i; j++){
                if (A[i]%A[j]==0 && D[j]+1>D[i])
                    D[i] = D[j]+1;
            }
        }
        int ans = 0;
        for(int i = 0; i < n;i++)
            ans = max(ans,D[i]);
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] inputArray = reader.readLine().split(" ");
        int [] workingArray = new int[n];
        for (int i= 0; i < n;i++)
            workingArray[i] = Integer.parseInt(inputArray[i]);
        System.out.println(LISBottomUp(workingArray,n));
    }
}
