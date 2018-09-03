package in.raji.bills.billsreminder.db.entity.dao.util;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooleanArrayConverter {

    @TypeConverter
    public static Boolean[] toInteger(String value) {
        List<String> list = new ArrayList<String>(Arrays.asList(value.split(" , ")));
        ArrayList<Boolean> booleanVal = new ArrayList<Boolean>();
        for (String val : list) {
            booleanVal.add(Boolean.parseBoolean(val));
        }
        return (Boolean[]) booleanVal.toArray();
    }

    @TypeConverter
    public static String toString(Boolean value[]) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean booleanVal : value) {
            stringBuilder.append(booleanVal.toString());

            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}

