package suport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Generator {
    public static String DateHourFile(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(ts);
    }

}
