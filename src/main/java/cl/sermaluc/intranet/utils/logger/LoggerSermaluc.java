package cl.sermaluc.intranet.utils.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom logger sermaluc extends functionality the slf4j
 */
public class LoggerSermaluc {

    private Logger logger;
    private final String BEGIN = "BEGIN";
    private final String EXECUTE = "EXECUTE";
    private final String ERROR = "ERROR";
    private final String END = "END";

    /**
     * Init logger with class param
     *
     * @param clazz implementation logger.
     */
    public LoggerSermaluc(Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public void infoBegin(String method, String msg){
        customLogger(BEGIN, method, msg);
    }
    public void infoBegin(String method){
        customLogger(BEGIN, method);
    }
    public void infoExecute(String method, String msg){
        customLogger(EXECUTE, method, msg);
    }
    public void infoExecute(String method){
        this.customLogger(EXECUTE, method);
    }
    public void infoEnd(String method, String msg){
        this.customLogger(END, method, msg);
    }
    public void infoEnd(String method){
        this.customLogger(END, method);
    }

    public void infoError(String method, String msg){
        this.customLogger(ERROR, method, msg);
    }


    private void customLogger(String init, String method, String msg){
        logger.info("["+init+"]         [" + method +"] = " + msg);
    }
    private void customLogger(String init, String method){
        logger.info("["+init+"]         [" + method +"]");
    }
}
