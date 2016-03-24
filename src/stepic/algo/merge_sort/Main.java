package stepic.algo.merge_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static long counter(int[] a, int n){
        return mergeSort(a,0,n-1);
    }

    private static int mergeSort (int[] arr, int low, int high) {
        if (low == high - 1) return 0;
        int mid = (low + high)/2;
        return mergeSort (arr, low, mid) + mergeSort (arr, mid, high) + merge (arr, low, mid, high);
    }

    private static int merge (int[] arr, int low, int mid, int high) {
        int invers = 0;
        int[] tmp = new int[arr.length];
        for (int k = low, i = low, j = mid; k < high; k++) {
            if (j >= high || i < mid && arr[i] <= arr[j]) {
                tmp[k]  = arr[i++];
            } else {
                invers = invers + (mid - i);
                tmp[k]  = arr[j++];
            }
        }
        System.arraycopy(tmp, low, arr, low, high - low);
        return invers;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] A = reader.readLine().split(" ");
        int[] arr = new int[n];
        int i =0;
        for(String s: A) {
            arr[i] = Integer.parseInt(s);
            i++;
        }
        System.out.println(counter(arr,arr.length));

    }
}
