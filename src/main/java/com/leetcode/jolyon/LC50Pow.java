package com.leetcode.jolyon;

public class LC50Pow {
    static class RecurSolution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (x == 0) return 0;
            // Change the value into long
            // Double.MAX_VALUE is greater than Long.MAX_VALUE
            long N = n;
            if (N < 0) {
                N = -N;
                x = 1 / x;
            }
            return pow(x, N);
        }

        private double pow(double x, long n) {
            if (n == 0) return 1.0;
            if (n == 1) return x;
            if (n % 2 == 0) {
                double half = pow(x, n / 2);
                return half * half;
            } else {
                long t = n - 1;
                double half = pow(x, t / 2);
                return half * half * x;
            }
        }
    }

    static class IterativeSolution {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            double base = x;
            long i = N;
            while (i > 0) {
                // In the end, i equal to 1;
                // When the LSB is 1, we need to multiple the 
                // base, we are trying to make the i can be 
                // divided by 2.
                if ((i % 2) == 1) {
                    ans = ans * base;
                    i = i - 1;
                }
                base = base * base;
                i = i >> 1;
            }
            return ans;
        }
    }
}
