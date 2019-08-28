package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC273IntegertoEnglishWords {
    static class Solution {
        private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        private final String[] SUFFIX = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {

            if(num==0) return "Zero";

            String ret="";
            int i=0;

            while(num>0){
                if(num%1000!=0){
                    ret = helper(num%1000) + SUFFIX[i] + " " + ret;
                }
                i++;
                num=num/1000;
            }

            return ret.trim();
        }

        private String helper(int num){
            if(num==0){
                return "";
            }else if(num<20){
                return LESS_THAN_20[num] + " ";
            } else if(num<100){
                return TENS[num/10] + " " + helper(num%10);
            } else{
                return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);
            }
        }

    }
    static class ClearSolution{
        private static final Map<Integer, String> map = new HashMap<>();
        private static final int BILLION = 1_000_000_000;
        private static final int MILLION = 1_000_000;
        private static final int THOUSAND = 1_000;

        public String numberToWords(int num) {
            initMap();
            if (num < 10)
                return map.get(num);
            StringBuilder ans = new StringBuilder();
            if (num >= BILLION) {
                ans.append(convert(num / BILLION)).append(" Billion");
                num %= BILLION;
            }
            if (MILLION <= num && num < BILLION) {
                ans.append(convert(num / MILLION)).append(" Million");
                num %= MILLION;
            }
            if (THOUSAND <= num && num < MILLION) {
                ans.append(convert(num / THOUSAND)).append(" Thousand");
                num %= THOUSAND;
            }
            if (num < THOUSAND)
                ans.append(convert(num));
            return ans.toString().trim();
        }

        private String convert(int t) {
            StringBuilder ans = new StringBuilder();
            int hun = t / 100;
            if (hun != 0)
                ans.append(" ").append(map.get(hun)).append(" Hundred");
            t %= 100;
            int ten = t / 10;
            if (ten != 0)
                ans.append(" ").append(ten == 1 ? map.get(t) : map.get(ten * 10));
            t %= 10;
            if (ten != 1 && t != 0)
                ans.append(" ").append(map.get(t));
            return ans.toString();
        }

        private void initMap() {
            map.put(0, "Zero");
            map.put(1, "One");
            map.put(2, "Two");
            map.put(3, "Three");
            map.put(4, "Four");
            map.put(5, "Five");
            map.put(6, "Six");
            map.put(7, "Seven");
            map.put(8, "Eight");
            map.put(9, "Nine");
            map.put(10, "Ten");
            map.put(11, "Eleven");
            map.put(12, "Twelve");
            map.put(13, "Thirteen");
            map.put(14, "Fourteen");
            map.put(15, "Fifteen");
            map.put(16, "Sixteen");
            map.put(17, "Seventeen");
            map.put(18, "Eighteen");
            map.put(19, "Nineteen");
            map.put(20, "Twenty");
            map.put(30, "Thirty");
            map.put(40, "Forty");
            map.put(50, "Fifty");
            map.put(60, "Sixty");
            map.put(70, "Seventy");
            map.put(80, "Eighty");
            map.put(90, "Ninety");
            map.put(100, "Hundred");
        }
    }
}
