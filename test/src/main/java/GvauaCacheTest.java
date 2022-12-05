import com.aliyun.openservices.shade.com.google.common.cache.CacheBuilder;
import javafx.util.Builder;

import java.util.concurrent.TimeUnit;

public class GvauaCacheTest {
    public static void main(String[] args) {
        CacheBuilder.newBuilder()
                .concurrencyLevel(16)
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .initialCapacity(5)
                .maximumSize(50)
                .build();
    }
}