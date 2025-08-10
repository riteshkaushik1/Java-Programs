import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static int solve(long[] nums, int width, int numOperations, long target) {
        int j = upperBound(nums, target - 1);
        int k = lowerBound(nums, target + 1);
        int j2 = upperBound(nums, target - 2 * width - 1);
        int k2 = lowerBound(nums, target + 2 * width + 1);
        return k - j + 1 + Math.min(j - j2 + k2 - k, numOperations);
    }

    public int maxFrequency(int[] input, int width, int numOperations) {
        long[] nums = Arrays.stream(input).sorted().mapToLong(i -> i * 2L).toArray();
        int ans = 0;
        for (long num : nums) {
            int c1 = solve(nums, width, numOperations, num);
            int c2 = solve(nums, width, numOperations, num - 2 * width);
            int c3 = solve(nums, width, numOperations, num + 2 * width);
            ans = Math.max(ans, Math.max(c1, Math.max(c2, c3)));
        }
        return ans;
    }

    private static int upperBound(long[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int lowerBound(long[] nums, long target) {
        int pos = upperBound(nums, target);
        return pos - (pos < nums.length && nums[pos] == target ? 0 : 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int width = sc.nextInt();
        int numOperations = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.maxFrequency(input, width, numOperations);
        System.out.println(result);

        sc.close();
    }
}

