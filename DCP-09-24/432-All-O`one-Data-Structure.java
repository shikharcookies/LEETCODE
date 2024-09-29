class AllOne {
    TreeMap<Integer,TreeSet<String>> t;
    HashMap<String,Integer> h;
    public AllOne() {
        t=new TreeMap<>(); 
        h=new HashMap<>();
    }
    
    public void inc(String key) {
        int count=h.getOrDefault(key,0);
        if(count>0){
            t.get(count).remove(key);
            if(t.get(count).isEmpty()){
                t.remove(count);
            }
        }
        h.put(key,count+1);
        if(!t.containsKey(count+1)){
            t.put(count+1, new TreeSet<>());
        }
        t.get(count+1).add(key);
    }
    
    public void dec(String key) {
        int count=h.getOrDefault(key,0);
        if(count==0){
            return;
        }
        t.get(count).remove(key);
        if(t.get(count).isEmpty()){
            t.remove(count);
        }
        if(count==1){
            h.remove(key);
        }else{
            h.put(key,count-1);
            if(!t.containsKey(count-1)){
                t.put(count-1,new TreeSet<>());
            }
            t.get(count-1).add(key);
        }
    }
    
    public String getMaxKey() {
        if(t.size()==0){
            return "";
        }
        
        return t.get(t.lastKey()).first();
    }
    
    public String getMinKey() {
        if(t.size()==0){
            return "";
        }
        
        return t.get(t.firstKey()).first();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */