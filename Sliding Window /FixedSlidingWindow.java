public class FixedSlidingWindow {
    // Find maximum sum of any subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int windowSum = 0, maxSum = 0;

        // Compute initial window sum
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " = " + result);
    }
}
