class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> s= new LinkedHashSet<>();
        for(int i: nums) s.add(i);
        List<Integer> l= new ArrayList<>(s);
        long lon=0;
        for(int i=0; i<l.size(); i++){
            int lo=1;
            long ele= l.get(i);
            while(ele*ele<= Integer.MAX_VALUE && s.contains((int)(ele*ele))){
                ele= ele*ele;
                lo+=1;
            }
            lon= Math.max(lon, lo);
        }
        return lon==1? -1: (int)lon;
    }
}