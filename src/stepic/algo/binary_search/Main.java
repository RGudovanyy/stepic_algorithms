package stepic.algo.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] strToInt(String[] string){
        int[] intarray = new int[string.length];
        int i = 0;
        for(String s : string)
            intarray[i++] = Integer.parseInt(s);
        return intarray;
    }

    static String[] cut(String[] string){
        String [] xx = new String[string.length-1];
        for (int i = 1; i<string.length;i++)
            xx[i-1] = string[i];
        return xx;
    }

    private static int binarySearch(int[] a, int key){
        int low = 0;
        int hight = a.length - 1;
        while (low <= hight){
            int mid = (low + hight)/2;
            int midVal = a[mid];
            if (midVal > key)
                hight = mid - 1;
            else if (midVal < key)
                low = mid + 1;
            else
                return mid;
        }
        return -2;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] n = reader.readLine().split(" ");
        String[] k = reader.readLine().split(" ");

        String[] arr = cut(n);
        String[] kk  = cut(k);
        int[] nums = strToInt(arr);
        int[] abr = strToInt(kk);
        for(int i : abr)
            System.out.print((binarySearch(nums,i)+1) + " ");
    }
}
