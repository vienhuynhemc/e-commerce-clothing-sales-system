package beans;

public class DateTimeConfiguration {

    //  Cái này nhận vào 1 string có cấu trúc giống như datetime chuyển thành datetime
    public static final int COVER_DATETIME_LIKE_CONSTRUCTOR = 1;

    //  Cái này nhận vào 1 string có cấu trúc datetime của input datetimelocal chuyển thành
    public static final int COVER_DATE_TIME_LIKE_DATETIME_LOCAL = 2;

    //  Cái này sẽ tạo mới một đối tượng DateTime có thời gian là ngày giờ hiện tại
    public static final int NOW_DATE = 3;

    //  Cái này sẽ tạo mới một đối tượng dateime có thời gian là ngày giờ hiện tại + thêm một ít phút trong tương lai
    public static final int NOW_DATE_ADD_SOME_MINUTE = 4;

    //  1 phút bằng bao nhiêu mili
    public static final long ONE_MINUTE_IN_MILLIS = 60000;

    //  1 giây bằng bao nhiêu mili
    public static final long ONE_SECOND_IN_MILIS = 1000;


}
