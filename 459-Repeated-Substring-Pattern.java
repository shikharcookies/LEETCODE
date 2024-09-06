class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int len=1; len<=n/2; len++){
            if( n%len != 0 ) 
            continue;
            if( s.substring(0, n-len).equals( s.substring(len)))
             return true;
        }
        return false;
    }
}