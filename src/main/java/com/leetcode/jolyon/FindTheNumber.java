package com.leetcode.jolyon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FindTheNumber {
    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        for(int n:arr){
            if(n==k){
                return "YES";
            }
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
//        BufferedReader bufferedReader =
//                new BufferedReader(new FileReader("/Users/LiZhuolun/WorkSpace/java/java-on-a-spree/src/main/resources/input000.txt"));
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(FindTheNumber.class.getResourceAsStream("/input000.txt")));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arrTemp = new ArrayList<>();

        IntStream.range(0, arrCount).forEach(i -> {
            try {
                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> arr = arrTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

