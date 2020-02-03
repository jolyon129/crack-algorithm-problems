package com.leetcode.jolyon.Sap;

import java.util.Scanner;

public class RearrangeDesks {
//    public static int solve() {
//        Scanner scan = new Scanner(System.in);
//        int R = Integer.parseInt(scan.nextLine());
//        int C = Integer.parseInt(scan.nextLine());
//        String[] rows = new String[R];
//        for (int i = 0; i < R; i++) {
//            rows[i] = scan.nextLine();
//        }
//        int count = 0;
//        int[][] seats = new int[R][C];
//        for (int i = 0; i < C; i++) {
//            String row = rows[0];
//            if (row.charAt(i) == '+') continue;
//            else {
//                if (i == 0 || seats[0][i - 1] != 1) {
//                    seats[0][i] = 1;
//                    count++;
//                }
//            }
//        }
//        for (int i = 1; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                String row = rows[i];
//                if (row.charAt(j) == '+') continue;
//                else {
//                    if (j == 0 || (seats[i - 1][j - 1] != 1 && seats[i][j - 1] != 1)) {
//                        seats[i][j] = 1;
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    static int ans = 0;

    public static int solve1() {
        Scanner scan = new Scanner(System.in);
        int R = Integer.parseInt(scan.nextLine());
        int C = Integer.parseInt(scan.nextLine());
        char[][] seats = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = scan.nextLine();
            for (int j = 0; j < C; j++) {
                seats[i][j] = tmp.charAt(j);
            }
        }
        int[][] memo = new int[R+2][C+2];
        recur(0, 0, memo, seats);
        return ans;

    }

    static void recur(int cur, int count, int[][] memo, char[][] seats) {
        if (cur == seats.length * seats[0].length) {
            ans = Math.max(count, ans);
            return;
        }
        int r = cur / seats[0].length;
        int c = cur % seats[0].length;
        if (seats[r][c] == '+') {
            recur(cur + 1, count, memo, seats);
        } else {
            int m_r = r + 1, m_c = c + 1;
            if (memo[m_r - 1][m_c - 1] == 0 && memo[m_r][m_c - 1] == 0 && memo[m_r - 1][m_c + 1] == 0) {
                memo[m_r][m_c] = 1;
                recur(cur + 1, count + 1, memo, seats);
                memo[m_r][m_c] = 0;
            }
            memo[m_r][m_c] = 0;
            recur(cur + 1, count, memo, seats);
        }
    }

    public static void main(String[] args) {
        int res = solve1();
        System.out.println(res);
    }

}
