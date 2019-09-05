package com.leetcode.jolyon;

import java.util.Arrays;

public class LC681NextClosestTime {
    public String nextClosestTime(String time) {
        char[] arr = time.toCharArray();
        char[] digits = new char[]{arr[0],arr[1],arr[3],arr[4]};
        Arrays.sort(digits);
        arr[4] = findNext(arr[4]-'0',9,digits);
        if(arr[4]>time.charAt(4)) return String.valueOf(arr);
        arr[3] = findNext(arr[3]-'0',5,digits);
        if(arr[3]>time.charAt(3)) return String.valueOf(arr);


        arr[1] = arr[0]=='2'?findNext(arr[1]-'0',3,digits):findNext(arr[1]-'0',9,digits);
        if(arr[1]>time.charAt(1)) return String.valueOf(arr);

        arr[0] = findNext(arr[0]-'0',2,digits);
        if(arr[0]>time.charAt(0)) return String.valueOf(arr);

        return String.valueOf(arr);

    }

    public char findNext(int current, int upperLimit, char[] digits){
        int d = digits[0]-'0';
        for(int i=0;i<4;i++){
            if(current<digits[i]-'0' && digits[i]-'0' <=upperLimit){
                d  = digits[i]-'0';
                break;
            }
        }
        return (char)(d+'0');
    }
}
