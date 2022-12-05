import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTTest<K, V> extends LinkedHashMap{
    private int capacity = 10;
//    private LinkedHashMap map = new LinkedHashMap(capacity, 0.75f, true);

//    private boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return true;
//    }

    public void put(K obj) {
        this.put(obj, null);
    }

    public Object getMy(K key) {
        return this.get(key);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new LRUTTest<>().put(i);
        }
    }
}
