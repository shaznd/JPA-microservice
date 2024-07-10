package dst.ass1.jpa.interceptor;


import dst.ass1.jpa.util.Constants;
import org.hibernate.EmptyInterceptor;
import org.jboss.logging.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class SQLInterceptor extends EmptyInterceptor {

    private static final long serialVersionUID = -1L;

    private static boolean verbose;
    private static int counter;

    public static void resetCounter() {
        counter = 0;
    }

    public static int getCounter() {
        return counter;
    }

    /**
     * If the verbose argument is set, the interceptor prints the intercepted SQL statements to System.out.
     *
     * @param verbose whether or not to be verbose
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public String onPrepareStatement(String sql) {
        if(sql.startsWith("select") && (sql.contains("Location") || sql.contains("trip")))
            ++counter;
        return sql;
    }

}
