class Solution {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int low, int high, int[] temp) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = 0;

        // Left half
        count += mergeSort(nums, low, mid, temp);

        // Right half
        count += mergeSort(nums, mid + 1, high, temp);

        // Count reverse pairs
        count += countPairs(nums, low, mid, high);

        // Normal merge
        merge(nums, low, mid, high, temp);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                   (long) nums[left] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid,
                       int high, int[] temp) {

        int left = low;
        int right = mid + 1;
        int k = low;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }
}