import java.text.SimpleDateFormat;
import java.util.Date;

interface DateFormatter {
    static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
