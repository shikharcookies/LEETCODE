class Solution {
    int c=0;
    public void help(String s, List<Character> l, int i){
        if(i==l.size()){
            StringBuilder sb= new StringBuilder();
            for(char c: l) sb.append(c);
            String st= new String(sb);
            String[] x= st.split("\\.");
            for(int j = 0; j < x.length; j++) {
                x[j] = x[j].replace(Character.toString('/'), "");
            }
            Set<String> set= new LinkedHashSet<>();
            for(String str1: x) set.add(str1);
            StringBuilder sb1= new StringBuilder();
            for(String str1: set) sb1.append(str1);
            if(sb1.toString().equals(s)) c=Math.max(c, set.size());
            return;
        }
        l.set(i, '.');
        help(s, l, i+2);
        l.set(i, '/');
        help(s, l, i+2);
    }
    public int maxUniqueSplit(String s) {
        List<Character> l= new ArrayList<>();
        for(char c: s.toCharArray()){
            l.add(c);
            l.add('/');
        }
        l.remove(l.size()-1);
        help(s, l, 1);
        return c;
    }
}