class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList<>();
        int n = arr.length;
        
        for (int size = n; size > 0; size--) {
            int maxIdx = getMaxIdx(arr, size);
            
            if (maxIdx != size - 1) {
                if (maxIdx != 0) {
                    flips.add(maxIdx + 1);
                    reverse(arr, 0, maxIdx);
                }
                
                flips.add(size);
                reverse(arr, 0, size - 1);
            }
        }
        
        return flips;
    }

    private static int getMaxIdx(int[] arr, int size) {
        int maxIdx = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}