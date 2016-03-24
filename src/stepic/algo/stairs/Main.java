package stepic.algo.stairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] degrees = reader.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(degrees[i]);
        }

        int prev = 0;
        int curr = arr[0];

        for(int i = 1; i < n; i++){
            int next = arr[i] + Math.max(prev,curr);
            prev = curr;
            curr = next;
        }
        System.out.println(curr);
    }
}
