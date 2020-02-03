package com.leetcode.jolyon.Sap;

import java.util.Scanner;

public class LargestNumberWithout3 {
    public static int solve(){
        Scanner scan = new Scanner(System.in);
        String arg = scan.nextLine();
        char[] arrs = arg.toCharArray();
        int mark =  arrs.length;
        for(int i= arrs.length-1;i>=0;i--){
            if(arrs[i] == '3'){
                mark = i;
                arrs[i]-=1;
            }
        }
        for(int i=mark+1;i<arrs.length;i++){
            arrs[i] = '9';
        }
        return Integer.parseInt(new String(arrs));
    }

    public static void main(String[] args) {
        int res = solve();
        System.out.println(res);
    }
}
