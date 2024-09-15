class Solution {
    public int minValidStrings(String[] words, String target) {
        Map<Character, List<char[]>> startingCharToWords = new HashMap<>();

        for (String word : words) {
            char startChar = word.charAt(0);
            startingCharToWords.computeIfAbsent(startChar, k -> new ArrayList<>()).add(word.toCharArray());
        }

        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1); 
        dp[0] = 0;

        char[] targetChars = target.toCharArray();

        for (int i = 0; i < n; i++) {
            if (dp[i] == n + 1) continue; 
            char c = targetChars[i];
            List<char[]> wordList = startingCharToWords.get(c);
            if (wordList == null) continue;
            for (char[] word : wordList) {
                int maxLen = Math.min(word.length, n - i);
                int len = 0;
                while (len < maxLen && targetChars[i + len] == word[len]) {
                    len++;
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }

        return dp[n] == n + 1 ? -1 : dp[n];
    }
}