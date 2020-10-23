public class SingleLeton {
    private static volatile SingleLeton instance;

    private SingleLeton() {
    }

    public SingleLeton getInstance() {
        if (null == instance) {
            synchronized (SingleLeton.class) {
                if (null == instance) {
                    instance = new SingleLeton();
                }
            }
        }
        return instance;
    }
}
