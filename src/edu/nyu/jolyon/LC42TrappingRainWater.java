package edu.nyu.jolyon;

public class LC42TrappingRainWater {
    public int trap(int[] height) {
        if(height.length<=2) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int water = 0;
        while (left < right - 1) {
            if (leftMax < rightMax) {
                left++;
                if (height[left] <= leftMax) water += leftMax - height[left];
                else leftMax = height[left];
            } else {
                right--;
                if (height[right] <= rightMax)
                    water += rightMax - height[right];
                else rightMax = height[right];
            }
        }
        return water;
    }
}
