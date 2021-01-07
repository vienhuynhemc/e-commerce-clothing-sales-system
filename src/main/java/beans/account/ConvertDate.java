package beans.account;

import beans.DateTime;

public class ConvertDate {

    public static DateTime changeDate(String line){

        if (line == null) return null;

        String[] split = line.split(" ");

        String[] dmy = split[0].split("-");
        String[] time = split[1].split(":");

        // sử lí lấy ra dc ngày tháng năm + time
        int year = Integer.parseInt(dmy[0]);
        int month = Integer.parseInt(dmy[1]);
        int day = Integer.parseInt(dmy[2]);
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        double d = Double.parseDouble(time[2]);

        int second = (int) d;

        return new DateTime(year,month,day,hour,minute,second);

    }

}
