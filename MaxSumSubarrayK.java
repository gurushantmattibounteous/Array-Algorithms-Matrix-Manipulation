public class MaxSumSubarrayK {

    public static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // Step 1: first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Step 2: slide window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i]; // add incoming
            windowSum -= nums[i - k]; // remove outgoing

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        System.out.println(maxSum(nums, k)); // Output: 9
    }
}