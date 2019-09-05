package com.leetcode.jolyon.viagogo;

import java.util.Scanner;


public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);

        String point1AsAString = scan.nextLine();
        String point2AsAString = scan.nextLine();

        String[] info1 = point1AsAString.split(" ");
        String[] info2 = point1AsAString.split(" ");
        int x1 = Integer.parseInt(info1[0]);
        int y1 = Integer.parseInt(info1[1]);
        int x2 = Integer.parseInt(info2[0]);
        int y2 = Integer.parseInt(info2[1]);
        // Need to parse each point and find the distance between them using the supplied CalculateManhattanDistance
        System.out.println(calculateManhattanDistance(x1, y1, x2, y2));

    }

    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}



