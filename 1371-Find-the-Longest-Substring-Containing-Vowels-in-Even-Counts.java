class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); //to handle the case where substring from start is answer

        int max=0,mask=0;

        for(int i=0;i<s.length();i++)
        {
            switch(s.charAt(i)) // flip the bit corresponding to current vowel using XOR
            {
                case 'a': mask^=32; break;  //32 = 10000
                case 'e': mask^=16; break;  //16 = 01000
                case 'i': mask^=8; break;    //8 = 00100
                case 'o': mask^=2; break;    //2 = 00010
                case 'u': mask^=1; break;    //1 = 00001
            }
            if(map.containsKey(mask)) // if the bitmask was seen before
            {
                max = Math.max(max, i - map.get(mask)); // length of valid substring
            }
            else
            {
                map.put(mask,i); // storing the first occurence of that bitmask
            }
        }
        return max;
    }
}