package beans.discountCode;

import beans.DateTime;

public class DiscountCode {

    //  Mã mã giảm giá trong database
    private String id;

    //  Mã nhập mã giảm giá ( người dùng nhập khi thanh toán )
    private String name;

    //  Kiểu của mã giảm giá - Miễn phí vận chuyển - Giảm theo % - Giảm theo số tiền nhất định
    private String type;

    //   = "" khi là MPVC , xxx % khi giảm theo %, xxx VND khi giảm theo số tiền nhất định
    private int value;

    //  Sô làn đã sử dụng
    private int numberOfUse;

    //  Số lần sử dụng tối đa
    private int maximunNumberOfUse;

    //  Số lần sử dụng còn lại
    private int remainNumberOfUse;

    //  Trạng thái - Còn đang được sử dụng hay không 0: Sử dụng, 1: Close
    private int status;

    //  Còn tồn tại hay không 0: Tồn tại, 1: Không tồn tại
    private int exists;

    //  Ngày tạo
    private DateTime dateCreated;

    //  Ngày hết hạn
    private DateTime deadline;

    //  Constructor với đầy đủ thông tin
    public DiscountCode(String id, String name, String type, int value, int numberOfUse, int maximunNumberOfUse, int remainNumberOfUse, int status, int exists, DateTime dateCreated, DateTime deadline) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.numberOfUse = numberOfUse;
        this.maximunNumberOfUse = maximunNumberOfUse;
        this.remainNumberOfUse = remainNumberOfUse;
        this.status = status;
        this.exists = exists;
        this.dateCreated = dateCreated;
        this.deadline = deadline;
    }

    //  Phương thức getValue()
    public String getStringValue() {

        String expand = type.compareTo("MPVC") == 0 ? "" : type;
        String stringValue = value + "";
        if(type.equals("MPVC")) stringValue = "";
        if (type.equals("VND")) {

            String saveValue = stringValue;
            stringValue = "";
            int count = 0;
            for (int i = saveValue.length() - 1; i >= 0; i--) {

                count++;
                stringValue = saveValue.charAt(i) + stringValue;
                if (count == 3 && i != 0) {
                    count = 0;
                    stringValue = "," + stringValue;
                }

            }
        }

        return stringValue + " " + expand;

    }


    //  GETTER AND SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfUse() {
        return numberOfUse;
    }

    public void setNumberOfUse(int numberOfUse) {
        this.numberOfUse = numberOfUse;
    }

    public int getMaximunNumberOfUse() {
        return maximunNumberOfUse;
    }

    public void setMaximunNumberOfUse(int maximunNumberOfUse) {
        this.maximunNumberOfUse = maximunNumberOfUse;
    }

    public int getRemainNumberOfUse() {
        return remainNumberOfUse;
    }

    public void setRemainNumberOfUse(int remainNumberOfUse) {
        this.remainNumberOfUse = remainNumberOfUse;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getExists() {
        return exists;
    }

    public void setExists(int exists) {
        this.exists = exists;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public DateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(DateTime deadline) {
        this.deadline = deadline;
    }

}
