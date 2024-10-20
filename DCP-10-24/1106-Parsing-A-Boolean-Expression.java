class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();
        return parseExpr(chars, new int[]{0});
    }
    
    private boolean parseExpr(char[] chars, int[] index) {
        char c = chars[index[0]];
        index[0]++;
        
        if (c == 't') return true;
        if (c == 'f') return false;
        
        boolean result = c == '|' ? false : true;
        index[0]++; // Skip '('
        
        while (chars[index[0]] != ')') {
            boolean value = parseExpr(chars, index);
            if (c == '!') {
                result = !value;
                break;  // NOT operation should only have one operand
            }
            if (c == '&') result &= value;
            if (c == '|') result |= value;
            if (chars[index[0]] == ',') index[0]++;
        }
        
        index[0]++; // Skip ')'
        return result;
    }
}