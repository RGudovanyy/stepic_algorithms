package stepic.algo.count_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void sort(int[] array){
        int[] barray = new int[11];
        for(int j = 0; j <= 10; j++)
            barray[j] = 0;
        for(int i = 0; i < array.length; i++)
            barray[array[i]]++;

        for (int j = 1; j <= 10; j++)
            barray[j] = barray[j]+barray[j-1];

        for(int i = array.length-1; i > 0; i--){
            array[barray[array[i]]-1] = array[i];
            barray[array[i]]--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        String nums = reader.readLine();
        for (int i = 0; i < n; i++)
            array[i] = (Integer.parseInt(nums.split(" ")[i]));
        sort(array);
        for(int i: array)
            System.out.print(i + " ");
    }
}
