
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 自定义LRU 类
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> {

    private final float loadFactory = 0.75f; //使用LinkedHashMap容量，负载因子使用默认的0.75
    private LinkedHashMap<K, V> map;

    public LRU(int maxCacheSize) {
        int capacity = (int)Math.ceil(maxCacheSize / this.loadFactory) + 1;// HashMap达到容量就进行扩容，if ((size >= threshold)，因此需要+1

        map = new LinkedHashMap<K, V>(capacity, loadFactory, true) {// accessOrder为true表示LRU

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) { // 重写removeEldestEntry，当容量超过maxCacheSize会移除first
                return size() > maxCacheSize;
            }
        };
    }

    /**
     * 都是调用 LinkedHashMap 的方法
     */
    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public boolean contain(K key) {
        return map.containsKey(key);
    }


    /**
     * 跑得快，一局四个人，轮流来，最先进场的先出来
     * @param args
     */
    public static void main(String[] args) {
        LRU<String, String> runFast = new LRU<String, String>(4);// 一局四个人参与
        Set<Map.Entry<String, String>> entries = runFast.map.entrySet();
        runFast.put("1号选手", "杨大郎");
        runFast.put("2号选手", "杨二郎");
        runFast.put("3号选手", "杨三郎");
        runFast.put("4号选手", "杨四郎");
        System.out.println("第一局跑得快参与人：");
        for (Map.Entry<String, String> map:entries){
            System.out.print(map.getKey()+"---------"+map.getValue()+"    ");
        }

        runFast.get("1号选手");// 杨大郎赢了
        runFast.get("4号选手");// 杨四郎赢了




        System.out.println();
        runFast.put("5号选手", "杨五郎");// 赢了的留下，输了的褪下（未被访问）
        runFast.put("6号选手", "杨六郎");


        System.out.println("第二局跑得快参与人：");// 二郎、三郎出局
        for (Map.Entry<String, String> map:entries){
            System.out.print(map.getKey()+"---------"+map.getValue()+"    ");
        }

        runFast.get("1号选手");// 杨大郎赢了（被get，调用afterNodeAccess排到末尾去）
        runFast.get("5号选手");// 杨五郎赢了


        System.out.println();
        runFast.put("7号选手", "杨七郎");
        runFast.put("8号选手", "杨业");


        System.out.println("第三局跑得快参与人：");// 四郎、六郎出局
        for (Map.Entry<String, String> map:entries){
            System.out.print(map.getKey()+"---------"+map.getValue()+"    ");
        }
        System.out.println();
    }
}


