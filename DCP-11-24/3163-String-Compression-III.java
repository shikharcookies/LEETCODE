class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < word.length()) {
            char curr = word.charAt(idx);
            int charcount = 0;
            while (idx < word.length() && word.charAt(idx) == curr
                    && charcount < 9) {
                charcount++;
                idx++;
            }
            sb.append(charcount).append(curr);
        }
        return sb.toString();
    }
}