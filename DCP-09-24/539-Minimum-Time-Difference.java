class Solution {
    public int findMinDifference(List<String> timePoints) {
        // time points => minutes(hour*60 + min)
        List<Integer> mins = new ArrayList<>();
        for(String time: timePoints)
        {
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            mins.add(hour*60 + min);
        }
        //list => minutes(sorted)
        Collections.sort(mins);
        // (a,b,c) => b-a < c-a
        int ans=Integer.MAX_VALUE;
        for (int i=1;i<mins.size();i++) // starting from 1 since we can't minus anything from a
        {
            ans = Math.min(ans,mins.get(i)-mins.get(i-1)); //min of b-a , c-a
        }
        // c can be more to closer to a than b
        ans = Math.min(ans, 24*60-(mins.get(mins.size()-1) - mins.get(0)));
        return ans;
    }
}