public class TrappedWater {
    public static void trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int waterTrapped = 0;

        System.out.println("Water trapped at each position:");
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    waterTrapped += maxLeft - height[left];
                    System.out.println("At index " + left + ": Water trapped = " + (maxLeft - height[left]) + " unit(s) (bounded by heights " + maxLeft + " and " + maxRight + ").");
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    waterTrapped += maxRight - height[right];
                    System.out.println("At index " + right + ": Water trapped = " + (maxRight - height[right]) + " unit(s) (bounded by heights " + maxLeft + " and " + maxRight + ").");
                }
                right--;
            }
        }

        System.out.println("Total water trapped: " + waterTrapped);
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap(height);
    }
}
