class AllOne {
    private HashMap<String, Integer> d;
    private TreeMap<Integer, TreeSet<String>> t;

    public AllOne() {
        d = new HashMap<>();
        t = new TreeMap<>();
    }

    public void inc(String key) {
        int count = d.getOrDefault(key, 0);
        if (count > 0) {
            t.get(count).remove(key);
            if (t.get(count).isEmpty()) {
                t.remove(count);
            }
        }
        d.put(key, count + 1);
        t.computeIfAbsent(count + 1, k -> new TreeSet<>()).add(key);
    }

    public void dec(String key) {
        int count = d.getOrDefault(key, 0);
        if (count > 0) {
            t.get(count).remove(key);
            if (t.get(count).isEmpty()) {
                t.remove(count);
            }
        }
        if (count > 1) {
            d.put(key, count - 1);
            t.computeIfAbsent(count - 1, k -> new TreeSet<>()).add(key);
        } else {
            d.remove(key);
        }
    }

    public String getMaxKey() {
        if (t.size() == 0) {
            return \\;
        }
        return t.get(t.lastKey()).first();
    }

    public String getMinKey() {
        if (t.size() == 0) {
            return \\;
        }
        return t.get(t.firstKey()).first();
    }
}