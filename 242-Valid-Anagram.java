class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length())    return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] count = new int[26];
        
        for(int i = 0; i < c1.length; ++i) {
            count[c1[i] - 'a']++;
             count[c2[i] - 'a']--;
        }
        
        for(int num: count) {
            if(num != 0)    return false;
        }
        return true;
    }
}