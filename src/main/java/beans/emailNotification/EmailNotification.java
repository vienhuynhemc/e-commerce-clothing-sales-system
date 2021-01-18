package beans.emailNotification;

import beans.DateTime;

public class EmailNotification {

    //  Tên và hình đại diện nhân viên thực hiện, lấy từ bảng tài_khoản
    private String nameStaff;
    private String linkImgStaff;

    //  Thông tin còn lại, lấy từ bảng email_thong_bao
    private String emailNotificationId;
    private String content;
    private DateTime dateSend;
    private int exists;
    private String title;
    private String staffId;

    //  Constructor rỗng xong, set từng cái cho object này
    public EmailNotification() {
    }

    //  GETTER AND SETTER
    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getLinkImgStaff() {
        return linkImgStaff;
    }

    public void setLinkImgStaff(String linkImgStaff) {
        this.linkImgStaff = linkImgStaff;
    }

    public String getEmailNotificationId() {
        return emailNotificationId;
    }

    public void setEmailNotificationId(String emailNotificationId) {
        this.emailNotificationId = emailNotificationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(DateTime dateSend) {
        this.dateSend = dateSend;
    }

    public int getExists() {
        return exists;
    }

    public void setExists(int exists) {
        this.exists = exists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

}
