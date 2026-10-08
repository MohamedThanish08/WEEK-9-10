import java.util.*;

public class Problem5 {

    static int maxContainerArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while (left < right) {

            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            int area = height * width;

            maxArea = Math.max(maxArea, area);

            // Move the shorter wall
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of heights: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter heights:");

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int result = maxContainerArea(heights);

        System.out.println("Maximum Container Area: " + result);

        sc.close();
    }
}