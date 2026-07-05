public class MovingSlidingWindow {
    // Smallest subarray with sum >= target
    public static int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];  // expand window

            // shrink window until condition breaks
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = minSubArrayLen(target, arr);
        System.out.println("Minimum length of subarray with sum ≥ " + target + " = " + result);
    }
}
