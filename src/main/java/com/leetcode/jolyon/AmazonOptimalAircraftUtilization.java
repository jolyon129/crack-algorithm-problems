package com.leetcode.jolyon;

import java.util.*;

public class AmazonOptimalAircraftUtilization {

    //BS
    public static int[][] getOptRoute(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        Arrays.sort(forwardRouteList, (a, b)->a[1] - b[1]);
        Arrays.sort(returnRouteList, (a, b)->a[1] - b[1]);
        Map<Integer, List<int[]>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int[] f : forwardRouteList) {
            int l=0, r = returnRouteList.length-1;
            while(l < r-1) {
                int m = l + (r - l)/2;
                int tmp = f[1] + returnRouteList[m][1];
                if(tmp > maxTravelDist){
                    r = m-1;
                }else {
                    l = m;
                }
            }
            int key = f[1] + returnRouteList[r][1] <= maxTravelDist ? f[1] + returnRouteList[r][1] : f[1] + returnRouteList[l][1];
            if(key <= maxTravelDist) {
                max = Math.max(max, key);
                List<int[]> lst = map.getOrDefault(key, new ArrayList<>());
                lst.add(new int[] {f[0], f[1] + returnRouteList[r][1] <= maxTravelDist ? returnRouteList[r][0] : returnRouteList[l][0]});
                map.put(key, lst);
            }
        }
        List<int[]> lst = map.get(max);
        int[][] res = new int[lst.size()][2];
        for(int i=0;i<lst.size();i++) {
            res[i][0] = lst.get(i)[0];
            res[i][1] = lst.get(i)[1];
        }
        for(int[] ele : res) {
            System.out.println(Arrays.toString(ele));
        }
        return res;
    }

    //2 pointers
    public static int[][] getOptRoute2(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        Arrays.sort(forwardRouteList, (a, b)->a[1] - b[1]);
        Arrays.sort(returnRouteList, (a, b)->a[1] - b[1]);
        Map<Integer, List<int[]>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int l = 0, r = returnRouteList.length - 1;
        while(l < forwardRouteList.length && r >= 0) {
            int tmp = forwardRouteList[l][1] + returnRouteList[r][1];
            if(tmp > maxTravelDist)
                r--;
            else {
                List<int[]> lst = map.getOrDefault(tmp, new ArrayList<>());
                lst.add(new int[] {forwardRouteList[l][0] , returnRouteList[r][0]});
                map.put(tmp, lst);
                max = tmp;
                l++;
            }
        }
        List<int[]> lst = map.get(max);
        int[][] res = new int[lst.size()][2];
        for(int i=0;i<lst.size();i++) {
            res[i][0] = lst.get(i)[0];
            res[i][1] = lst.get(i)[1];
        }
        for(int[] ele : res) {
            System.out.println(Arrays.toString(ele));
        }
        return res;
    }
}
