package ru.matthew8913.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            maxArea = Math.max(area, maxArea);
            if(height[l]>height[r]) r--;
            else if (height[r]>height[l]) l++;
            else { l++; r--; }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        int[][] testCases = {
                {1,8,6,2,5,4,8,3,7},  // Стандартный кейс (LeetCode Example 1) -> 49
                {1,1},                // Минимальный массив -> 1
                {4,3,2,1,4},          // Широкий контейнер с высокими краями -> 16
                {1,2,1},              // Маленький массив -> 2
                {0, 2},               // С нулем -> 0
                {2,3,4,5,18,17,6}     // Пик в конце -> 17
        };

        System.out.println("--- Running Tests ---");
        for (int[] heights : testCases) {
            int result = solver.maxArea(heights);
            System.out.print("Input: [");
            for (int i = 0; i < heights.length; i++) {
                System.out.print(heights[i] + (i < heights.length - 1 ? "," : ""));
            }
            System.out.println("] -> Max Area: " + result);
        }
    }
}
