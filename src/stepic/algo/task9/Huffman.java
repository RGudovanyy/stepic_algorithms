package stepic.algo.task9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Huffman  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int k = Integer.parseInt(input.split(" ")[0]);
        int l = Integer.parseInt(input.split(" ")[1]);
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            String input2 = reader.readLine();
            map.put(input2.split(": ")[1],input2.split(": ")[0]);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(reader.readLine());
        String res = " ";
        int i = 1;
        while (builder.length()>0) {
            if (map.containsKey(builder.substring(0, i))) {
                res += map.get(builder.substring(0, i));
                builder = builder.delete(0, i);
                i = 1;
            } else {
                i += 1;
            }
        }
       System.out.println(res.trim());
    }
}






