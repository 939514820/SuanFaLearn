import javafx.util.Builder;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class GvauaCacheTest {
    public static void main(String[] args) {
//        ArrayBlockingQueue queue=new ArrayBlockingQueue(1);
//        queue.offer(1);
//        HashMap<String,Object> map=new HashMap<>();
        ConcurrentHashMap<String,String> map1=new ConcurrentHashMap<>();
        map1.put("1","1");
        map1.put("1","2");

    }
}