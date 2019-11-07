package com.leetcode.jolyon;

public class LC551StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(c=='A'){
                countA++;
                countL=0;
            }else if(c=='L'){
                countL++;
            }else{
                countL=0;
            }
            if(countA>1 || countL>2){
                return false;
            }
        }
        return true;
    }
}
