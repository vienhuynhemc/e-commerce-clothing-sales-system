package beans;

public class DateTime {

    //  Lớp này đại diện cho thuộc tính datatime trong mysql
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    //  Constuctor
    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //  Constructor rỗng
    public DateTime() {
    }

    //  To string all
    public String toString() {
        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }

    //  To string dạng 26 Tháng Tám 2020
    public String toStringDateTypeNumberStringNumber() {

        //  Chuyển tháng từ số sang dạng chuỗi
        String mm = null;

        switch (this.month) {
            case 1:
                mm = "Tháng Một";
                break;
            case 2:
                mm = "Tháng Hai";
                break;
            case 3:
                mm = "Tháng Ba";
                break;
            case 4:
                mm = "Tháng Tư";
                break;
            case 5:
                mm = "Tháng Năm";
                break;
            case 6:
                mm = "Tháng Sáu";
                break;
            case 7:
                mm = "Tháng Bảy";
                break;
            case 8:
                mm = "Tháng Tám";
                break;
            case 9:
                mm = "Tháng Chín";
                break;
            case 10:
                mm = "Tháng Mười";
                break;
            case 11:
                mm = "Tháng Mời Một";
                break;
            case 12:
                mm = "Tháng Mười Hai";
                break;
        }

        //  return về dạng mình mong muốn
        return day + " " + mm + " " + year;

    }

    //  Getter and setter
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}
