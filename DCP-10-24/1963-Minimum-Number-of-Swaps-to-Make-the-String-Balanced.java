class Solution {
    public int minSwaps(String s) {
        int closedBrackets = 0, openBrackets = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (openBrackets > 0) 
                    --openBrackets;
                else
                    ++closedBrackets;
            } else {
                openBrackets++;
            }
        }

        return ((closedBrackets + 1) >> 1);
    }
}