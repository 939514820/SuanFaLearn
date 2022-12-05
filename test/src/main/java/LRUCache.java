import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap {
    /**
     * 构造方法
     *
     * @param size
     */
    public LRUCache(int size) {
        super(size, 0.75f, true);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        System.out.println("remove");
        return true;
    }

    public Object lruPut(K obj, V v) {
        return this.put(obj, v);
    }

    public Object lruGet(K key) {
        return this.get(key);
    }

    public static void main(String[] args) {
        LRUCache<Object, Object> cache = new LRUCache<>(16);
        int size = cache.size();
        for (int i = 0; i < 10; i++) {
            cache.lruPut(i, i);
        }
        cache.get(1);
        int size1 = cache.size();
        cache.lruPut(11, 4);
        int size2 = cache.size();
        System.out.println(size + "-" + size1 + "-" + size2);

    }
}
