import org.apache.log4j.Logger;

public class Logging{

    static final Logger log = Logger.getLogger(Logging.class);

    static void logAction(String message, ELogNotifications e){
        System.out.println("\n" + message);
        if(e == ELogNotifications.INFO){
            log.info(message);
        } else{
            log.error(message);
        }

    };
}
