class Solution {
    public boolean rotateString(String s, String goal) {
        // Edge
        if (s.length() != goal.length()) {
            return false;
        }
        
        return ((s + s).indexOf(goal) >= 0);
    }
}