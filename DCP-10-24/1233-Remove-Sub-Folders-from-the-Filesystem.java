class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        list.add(folder[0]);

        for(int i=1; i<folder.length; ++i) {
            String prev = list.get(list.size() -1) + "/";

            if(folder[i].indexOf(prev) == 0)
                continue;
            
            list.add(folder[i]);
        }

        return list;
    }
}