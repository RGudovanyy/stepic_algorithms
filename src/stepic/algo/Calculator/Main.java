package stepic.algo.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void division(int n){
        int[] arr = new int[n+1];
        int[] prev = new int[n+1];
        prev[1] = 0;
        arr[1] = 0;
        for (int i = 2; i <= n; i++){
            arr[i] = 1+ arr[i-1];
            prev[i] = i;
            if(i%2==0) {
                arr[i] = Math.min(arr[i], 1 + arr[i / 2]);
                prev[i] = i / 2;
            }
            if(i%3==0) {
                arr[i] = Math.min(arr[i], 1 + arr[i / 3]);
                prev[i] = i/3;
            }
        }

        //System.out.println(arr[n]);
        //System.out.println(arr[n]);
        for(int a : prev)
            System.out.println(a);
    }



    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        division(n);


    }
}
