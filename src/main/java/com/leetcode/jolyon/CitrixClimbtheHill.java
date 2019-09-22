package com.leetcode.jolyon;

public class CitrixClimbtheHill {
    int climbTheHill(int[] steps) {
        if (steps.length == 1) return 0;
        int cost1 = 0;
        int cost2 = 0;
        int cost3 = 0;
        int cost4 = 0;
        int ans;
        int prev1 = steps[0];
        int prev2 = steps[0];
        for (int i = 1; i < steps.length; i++) {
            if (steps[i] < prev1) {
                cost1 += prev1 - steps[i];
            }
            prev1 = Math.max(steps[i], prev1);
            if (steps[i] > prev2) {
                cost2 += steps[i] - prev2;
            }
            prev2 = Math.min(steps[i], prev2);
        }
        ans = Math.min(cost1, cost2);
        prev1 = steps[steps.length - 1];
        prev2 = steps[steps.length - 1];
        for (int i = steps.length - 2; i >= 0; i--) {
            if (steps[i] > prev1) {
                cost3 += steps[i] - prev1;
            }
            prev1 = Math.min(prev1, steps[i]);
            if (steps[i] < prev2) {
                cost4 += prev2 - steps[i];
            }
            prev2 = Math.max(prev2, steps[i]);
        }
        ans = Math.min(ans, cost3);
        ans = Math.min(ans, cost4);
        return ans;
    }


//    https://www.cnblogs.com/liuliu5151/p/11509823.html
//
//    public static int getMinimumCost(List<Integer> input) {
//        if (input == null || input.size() == 0) {
//            return 0;
//        }
//        return Math.min(getMinimumCost(input, false), getMinimumCost(input, true));
//    }
//    private static int getMinimumCost(List<Integer> input, boolean reverse) {
//
//        List<Integer> sorted = new ArrayList<>(input);
//        Collections.sort(sorted);
//        if (reverse) {
//            Collections.reverse(sorted);
//        }
//        int[][] dp = new int[input.size()][sorted.size()];
//        dp[0][0] = Math.abs(input.get(0) - sorted.get(0));
//        for (int i = 1; i < input.size(); i++) {
//            dp[i][0] = dp[i - 1][0] + Math.abs(input.get(i) - sorted.get(0));
//        }
//        for (int j = 1; j < sorted.size(); j++) {
//            dp[0][j] = Math.min(dp[0][j - 1],
//                    Math.abs(input.get(0) - sorted.get(j)));
//        }
//        for (int i = 1; i < input.size(); i++) {
//            for (int j = 1; j < sorted.size(); j++) {
//                dp[i][j] = Math.min(dp[i][j - 1],
//                        dp[i - 1][j] + Math.abs(input.get(i) - sorted.get(j)));
//            }
//        }
//        return dp[input.size() - 1][sorted.size() - 1];
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getMinimumCost(new int[]{0,1,2,5,5,4,4}));
//        System.out.println(getMinimumCost(new int[]{7,5,6,5,2,1,0}));
//        System.out.println(getMinimumCost(new int[]{9,8,7,2,3,3}));
//    }
}
