package dst.ass1.jpa.listener;
import javax.persistence.*;

public class DefaultListener {


    private static int loadOperations;
    private static int updateOperations;
    private static int removeOperations;
    private static int persistOperations;
    private static double overallTimeToPersist;

    @PostRemove
    public void postRemove(Object o)
    {
        ++removeOperations;
    }
    @PostUpdate
    public void postUpdate(Object o)
    {
        ++updateOperations;
    }
    @PostLoad
    public void postLoad(Object obj) {
        ++loadOperations;
    }

    public static int getLoadOperations() {
        return loadOperations;
    }

    public static int getUpdateOperations() {
        return updateOperations;
    }

    public static int getRemoveOperations() {
        return removeOperations;
    }

    public static int getPersistOperations() {
        return persistOperations;
    }

    public static double getOverallTimeToPersist() {
        return overallTimeToPersist;
    }

    public static double getAverageTimeToPersist() {

        if (DefaultListener.persistOperations == 0)
            return 0;
        return overallTimeToPersist/persistOperations;
    }

    public static void clear() {
        loadOperations= 0;
        updateOperations = 0;
        removeOperations = 0;
        persistOperations = 0;
        overallTimeToPersist = 0;
    }
}


