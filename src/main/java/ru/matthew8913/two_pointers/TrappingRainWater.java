package ru.matthew8913.two_pointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftWall = height[l];
        int rightWall = height[r];
        int totalWater=0;
        while(l<r){
            if(rightWall<leftWall){
                r--;
                rightWall = Math.max(rightWall, height[r]);
                int maxLevel = rightWall;
                totalWater += maxLevel - height[r];
            }else{
                l++;
                leftWall = Math.max(leftWall, height[l]);
                int maxLevel = leftWall;
                totalWater += maxLevel - height[l];

            }
        }
        return totalWater;
    }
}
