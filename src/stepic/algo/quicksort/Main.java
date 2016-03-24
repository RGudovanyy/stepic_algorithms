package stepic.algo.quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
/*
    public static void quickSort(int[] A, int p, int r){
        if(p >= r)
            return;
        int q = partition(A,p,r);
        quickSort(A,p,q-1);
        quickSort(A,q+1,r);
    }
    public static int partition(int[] A, int p, int r){
        int q = p;
        for(int u = p; u < r-1; u++){
            if(A[u] <= A[r]) {
                int tmp = A[q];
                A[q] = A[u];
                A[u] = tmp;
                q++;
            }
        }
        int tmp = A[q];
        A[q]= A[r];
        A[r] = tmp;
        return q;
    }

    */
    public static int difference(int[] left, int[] right, int k){
        int i, j;
        i = first(left,0, left.length-1,k);
        j = last(right,0,right.length-1,k);
        return Math.abs(i-j) ;
    }
    public static int first(int[] arr, int low, int high, int k) { // ищем кол-во чисел в массиве левых концов
        if (high >= low) {
            int mid = (low + high) / 2;
            if (k >= arr[mid] && (arr[mid + 1] > k || arr[mid] == 0))
                return mid;
            else if (k > arr[mid])
                return first(arr, (mid + 1), high, k);
            else
                return first(arr, low, (mid - 1), k);
        }
        return -1;
    }
 public static int last(int[] arr, int low, int high, int k){ // ищем кол-во чисел в массиве правых концов
        if(high >= low){
            int mid = (low + high)/2;
            if (k > arr[mid] && (arr[mid+1] > k || mid == high-1))
                return mid;
            else if(k < arr[mid])
                return last(arr, low, (mid -1), k);
            else if (k > arr[mid])
                return last(arr, (mid + 1), high, k);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        long before = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String NM = reader.readLine();
        int N = Integer.parseInt(NM.split(" ")[0]);
        int M = Integer.parseInt(NM.split(" ")[1]);
        int[] leftArray =  new int[N];
        int[] rightArray =  new int[N];
        //int[]arrayOfDottes = new int[M];
        for (int i = 0; i < N; i++){
            String line = reader.readLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            int tmp = 0;
            if (b < a){
                tmp = a;
                a = b;
                b = tmp;
            }
            leftArray[i] = a;
            rightArray[i] = b;
        }
        Arrays.sort(leftArray);
        Arrays.sort(rightArray);

        /*
        for(int i : leftArray)
            System.out.print(i + " ");

        for (int j : rightArray)
            System.out.print(j + " ");
        System.out.println();
*/

        String dottes = reader.readLine();
        for (int j = 0; j < M; j++){
            int a = Integer.parseInt(dottes.split(" ")[j]);
            System.out.println("a is : " + a);
            System.out.println(difference(leftArray,rightArray,a)+ " ");
        }

/*
        for(int i : leftArray)
            System.out.print(i + " ");

        for (int j : rightArray)
            System.out.print(j + " ");
        System.out.println();

        for (int i : arrayOfDottes)
            System.out.print(i + " ");
        System.out.println();
*/


        long after = System.currentTimeMillis();
        long diff = after - before;
        System.out.println();
        System.out.println(diff + " ms");
    }

}
