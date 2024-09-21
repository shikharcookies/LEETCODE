class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Get lengths of the arrays
        int n = nums1.length, m = nums2.length;

        // Create a new array to hold the merged elements
        int[] newArr = new int[n + m];

        // Indices for iterating through the arrays
        int i = 0, j = 0, k = 0;

        // Merge the arrays in sorted order
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                newArr[k++] = nums1[i++];
            } else {
                newArr[k++] = nums2[j++];
            }
        }

        // Add any remaining elements from the non-empty array
        while (i < n) {
            newArr[k++] = nums1[i++];
        }
        while (j < m) {
            newArr[k++] = nums2[j++];
        }

        // Calculate the median based on the total number of elements
        if ((n + m) % 2 == 0) {
            return (double) (newArr[(n + m) / 2] + newArr[((n + m) / 2) - 1]) / 2;
        } else {
            return newArr[(n + m) / 2];
        }
    }
}