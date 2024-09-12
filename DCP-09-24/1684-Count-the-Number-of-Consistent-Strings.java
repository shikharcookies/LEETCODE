class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int count=0;
        for(String k:words){
            int a=1;
            for(int i=0;i<k.length();i++){
                if(!set.contains(k.charAt(i))) {
                    a=0;
                    break;
                }
            }
            count+=a;
        }
        return count;
    }
}