package other;

import java.util.LinkedHashMap;
import java.util.Map;

//146. LRU 缓存
class L146_LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity = 0;

    public L146_LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > this.capacity;
    }

}