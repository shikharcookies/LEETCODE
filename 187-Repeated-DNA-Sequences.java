class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();


        for(int i =0;i<s.length()-9;i++)
        {
            String curr = s.substring(i,i+10);
            if(seen.contains(curr))
            {
                res.add(curr);
            }
            seen.add(curr);
        }
        return new ArrayList<>(res);
    }
}