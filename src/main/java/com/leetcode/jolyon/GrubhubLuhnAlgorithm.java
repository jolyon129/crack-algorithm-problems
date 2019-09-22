package com.leetcode.jolyon;

public class GrubhubLuhnAlgorithm {
    public boolean isValid(String numbers) {
        int sum = 0;
        int N = numbers.length();
        for(int i=1;i<=N;i++){
            int digit = numbers.charAt(N - i)-'0';
            if(i%2==1){
                sum += digit;
            }else{
                int tmp = digit*2;
                if(tmp>9) tmp = 1+ tmp % 10;
                sum += tmp;
            }
        }
        return (sum % 10) == 0;
    }
}
