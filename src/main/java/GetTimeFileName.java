import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeFileName {
    public static String timeFileName() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", date);
        //System.out.println(date);
        return formattedDate;
    }
}