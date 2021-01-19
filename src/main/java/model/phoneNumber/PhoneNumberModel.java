package model.phoneNumber;

public class PhoneNumberModel {

    private static PhoneNumberModel phoneNumberModel;

    public static PhoneNumberModel getInstance() {

        if (phoneNumberModel == null) {
            phoneNumberModel = new PhoneNumberModel();
        }

        return phoneNumberModel;

    }

    //  Phuơng thức nhận vô 1 số điện thoại trả về số điện thoại có dạng 0971-122-209
    public String numberToNumberAndDot(String phoneNumber){
        String result = phoneNumber.substring(0,4)+"-"+phoneNumber.substring(4,7)+"-"+phoneNumber.substring(7,10);
        return result;
    }



}
