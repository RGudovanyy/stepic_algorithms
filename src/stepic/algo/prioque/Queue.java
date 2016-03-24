package stepic.algo.prioque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue  {
    public static void main(String[] args) throws IOException {
        Comparator <Integer> comparator  = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                if (o1< o2)
                    return 1;
                return 0;
            }
        };
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> intQueue = new PriorityQueue<>(1000,comparator);

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i <n; i++){
            String a = reader.readLine();
            if (a.startsWith("Insert")){
                intQueue.offer(Integer.parseInt(a.split(" ")[1]));
            }
            if (a.startsWith("ExtractMax")){
                int f = intQueue.poll();
                System.out.println(f);
            }
        }
    }
}
