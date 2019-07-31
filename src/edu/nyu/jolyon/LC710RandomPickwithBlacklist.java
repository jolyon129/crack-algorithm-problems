package edu.nyu.jolyon;
import java.util.*;

public class LC710RandomPickwithBlacklist {
    static class Solution {
        int Wlen;
        int B;
        Map<Integer,Integer> map;

        public Solution(int N, int[] blacklist) {
            B = blacklist.length;
            Wlen = N - B;
            map = new HashMap<>();
            for(int b:blacklist) map.put(b,-1);
            int start = Wlen;
            for(int b:blacklist){
               if(b<Wlen){
                   while(map.containsKey(start)){
                       start++;
                   }
                   map.put(b,start);
                   start++;
               }
            }
        }
        public int pick() {
            Random rd =new Random();
            int t = rd.nextInt(Wlen);
            if(map.containsKey(t)){
                return map.get(t);
            }else{
                return t;
            }
        }
    }
}
