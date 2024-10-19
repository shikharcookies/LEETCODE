class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0'; // Base case
        int len = (1 << n) - 1; // Length of S_n
        if (k - 1 == len / 2) return '1'; // Middle bit
        if (k - 1 < len / 2) {
            return findKthBit(n - 1, k); // Left half
        } else {
            return (findKthBit(n - 1, len - k + 1) == '0') ? '1' : '0'; // Right half
        }
    }
}