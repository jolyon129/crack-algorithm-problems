package com.leetcode.jolyon.amazon;

public class Oa3 {
    static int[] letterToInt(String input){
        System.out.print(input +": ");
        int[] res = new int[input.length()];
        for(int i=0;i<input.length();i++){
            res[i] = input.charAt(i)-'A';
            System.out.print(res[i]+" ");
        }
        System.out.println("");
        return res;
    }
    static char[] intToLetter(int[] input){
        char[] res = new char[input.length];
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.print(": ");
        for(int i=0;i<input.length;i++){
            res[i] = (char) (input[i]+'A');
            System.out.print(res[i]+" ");
        }

        System.out.println("");
        return res;
    }

    public static void main(String[] args) {
//        letterToInt("STV");
//        letterToInt("XYA");
//        letterToInt("KKT");
        letterToInt("NORMAL");
        letterToInt("LAMRON");
//        letterToInt("EGL");
//        letterToInt("TVZ");

//        intToLetter(new int[]{4, 5, 12, 8, 9});
//        intToLetter(new int[]{3, 4, 1, 7, 8});
    }
}
