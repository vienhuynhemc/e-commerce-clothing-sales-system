package beans.personalNotice;

import beans.DateTime;
import beans.DateTimeConfiguration;

import java.util.Date;

public class PersonalNotice {

    //  Thời gian đã trôi qua
    private String overTime;

    //  Nội dung 1->5
    private String content_1;
    private String content_2;
    private String content_3;
    private String content_4;
    private String content_5;

    public PersonalNotice() {
    }

    //  GETTER AND SETTER
    public String getOverTime() {
        return overTime;
    }

    //  Hàm set hơi đặc biệt ,nhận vô datetime từ csdl và chuyển về thời gian còn lại
    public void setOverTime(String overTime) {
        DateTime dateTime = new DateTime(overTime);

        //  Lấy thời gian hiện tại
        Date nowDate = new Date();

        //  Chuyển dateTime -> date()
        Date date = new Date(dateTime.getYear()-1900,dateTime.getMonth()-1,dateTime.getDay(),dateTime.getHour(),dateTime.getMinute(),dateTime.getSecond());

        //  Lấy thời gian chênh lệch
        long over = nowDate.getTime() - date.getTime();
        if(over< DateTimeConfiguration.ONE_MINUTE_IN_MILLIS){
            this.overTime = over/DateTimeConfiguration.ONE_SECOND_IN_MILIS+" giây trước";
        }else if(over < DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60){
            this.overTime = over/DateTimeConfiguration.ONE_MINUTE_IN_MILLIS+" phút trước";
        }else if(over < DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60*24){
            this.overTime = over/(DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60)+" giờ trước";
        }else if(over < DateTimeConfiguration.ONE_MINUTE_IN_MILLIS*60*24*7){
            this.overTime = over / (DateTimeConfiguration.ONE_MINUTE_IN_MILLIS*60*24)+" ngày trước";
        }else if(over<DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60*24*30){
            this.overTime = over/ (DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60*24*7)+" tuần trước";
        }else if(over<DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60*24*365){
            this.overTime = over/ (DateTimeConfiguration.ONE_MINUTE_IN_MILLIS *60*24*30)+" tháng trước";
        }
    }

    public String getContent_1() {
        return content_1;
    }

    public void setContent_1(String content_1) {
        this.content_1 = content_1;
    }

    public String getContent_2() {
        return content_2;
    }

    public void setContent_2(String content_2) {
        this.content_2 = content_2;
    }

    public String getContent_3() {
        return content_3;
    }

    public void setContent_3(String content_3) {
        this.content_3 = content_3;
    }

    public String getContent_4() {
        return content_4;
    }

    public void setContent_4(String content_4) {
        this.content_4 = content_4;
    }

    public String getContent_5() {
        return content_5;
    }

    public void setContent_5(String content_5) {
        this.content_5 = content_5;
    }
}
