package com.leetcode.jolyon;

public class LC42TrappingRainWater {
    public int trap(int[] height) {
        if(height.length<=2) return 0;
        int left = 0;
        int leftMax = height[left];
        int right =height.length-1;
        int rightMax=height[right];
        int sum = 0;
        while(left<=right){
            leftMax = height[left]>leftMax?height[left]:leftMax;
            rightMax = height[right]>rightMax?height[right]:rightMax;
            if(left==0 && right==height.length-1){
                left++;
                continue;
            }
            if(leftMax<=rightMax){
                sum += Math.min(leftMax,rightMax) - height[left];
                left++;
            }else{
                sum += Math.min(leftMax,rightMax) - height[right];
                right --;
            }
        }
        return sum;
    }
}
