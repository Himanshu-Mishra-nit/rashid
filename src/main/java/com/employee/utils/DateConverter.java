package com.employee.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface DateConverter {

    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(date);
      Date sqlDate = new Date(utilDate.getTime());
      return sqlDate;

    }

}
