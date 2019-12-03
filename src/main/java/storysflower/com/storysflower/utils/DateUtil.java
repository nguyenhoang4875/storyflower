package storysflower.com.storysflower.utils;

import java.sql.Date;
import java.sql.Timestamp;

public class DateUtil {
    public static Timestamp convertFromStringToTimeStamp(String date) {
        return Timestamp.valueOf(date);
    }

    public static Date convertFromStringToDaTe(String date) {
        return Date.valueOf(date);
    }
}
